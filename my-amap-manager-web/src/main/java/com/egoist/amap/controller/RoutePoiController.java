package com.egoist.amap.controller;

import com.egoist.amap.pojo.RoutePoi;
import com.egoist.amap.request.SaveRoutePoiRequest;
import com.egoist.amap.service.RoutePoiService;
import com.egoist.amap.vo.PoiLocationVO;
import com.egoist.amap.vo.RoutePoiVO;
import com.egoist.parent.common.constants.EgoistExceptionStatusConstant;
import com.egoist.parent.common.enums.EgoistTableRecordStatusEnum;
import com.egoist.parent.common.utils.collection.EgoistCollectionUtil;
import com.egoist.parent.pojo.dto.EgoistResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class RoutePoiController {
    @Autowired
    private RoutePoiService routePoiService;

    /**
     * 获取行程地点列表
     *
     * @return
     */
    @PostMapping("getRoutePoiList")
    public EgoistResult getRoutePoiList() {
        try {
            List<RoutePoiVO> finalList = new ArrayList<>();
            EgoistResult result = routePoiService.getAll();
            if (EgoistResult.isOk(result)) {
                List<RoutePoi> originList = (List<RoutePoi>) result.getData();
                if (EgoistCollectionUtil.isNotEmpty(originList)) {
                    originList.forEach(poi -> {
                        RoutePoiVO routePoiVO = this.convertToRoutePoiVO(poi);
                        finalList.add(routePoiVO);
                    });
                }
            }
            return EgoistResult.ok(finalList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new EgoistResult(EgoistExceptionStatusConstant.STATUS_500, e.getMessage(), Collections.EMPTY_LIST);
        }
    }

    /**
     * poi转换成VO
     *
     * @param poi
     * @return
     */
    private RoutePoiVO convertToRoutePoiVO(RoutePoi poi) {
        PoiLocationVO poiLocationVO = new PoiLocationVO();
        poiLocationVO.setP(poi.getLat());
        poiLocationVO.setO(poi.getLng());
        poiLocationVO.setLat(poi.getLat());
        poiLocationVO.setLng(poi.getLng());
        RoutePoiVO routePoiVO = new RoutePoiVO();
        routePoiVO.setId(poi.getPoiId());
        routePoiVO.setName(poi.getPoiName());
        routePoiVO.setType(poi.getPoiType());
        routePoiVO.setLocation(poiLocationVO);
        routePoiVO.setAddress(poi.getAddress());
        routePoiVO.setTel(poi.getTel());
        routePoiVO.setShopinfo(poi.getShopinfo());
        routePoiVO.setLat(poi.getLat());
        routePoiVO.setLng(poi.getLng());
        return routePoiVO;
    }

    /**
     * 保存行程地点列表
     *
     * @return
     */
    @PostMapping("saveRoutePoiList")
    public EgoistResult saveRoutePoiList(@RequestBody SaveRoutePoiRequest saveRoutePoiRequest) {
        try {
            List<RoutePoiVO> poiVOList = saveRoutePoiRequest.getList();
            if (EgoistCollectionUtil.isEmpty(poiVOList)) {
                return EgoistResult.ok();
            }
            Date date = new Date();
            List<RoutePoi> poiList = new ArrayList<>();
            for (int i = 0; i < poiVOList.size(); i++) {
                RoutePoi poi = this.convertToRoutePoi(poiVOList.get(i), date, i + 1);
                poiList.add(poi);
            }
            routePoiService.delAll();
            routePoiService.saveAll(poiList);
            return EgoistResult.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new EgoistResult(EgoistExceptionStatusConstant.STATUS_500, e.getMessage(), null);
        }
    }

    /**
     * VO转换成poi
     *
     * @param poiVO
     * @param date
     * @param order
     * @return
     */
    private RoutePoi convertToRoutePoi(RoutePoiVO poiVO, Date date, Integer order) {
        RoutePoi poi = new RoutePoi();
        poi.setPoiId(poiVO.getId());
        poi.setPoiName(poiVO.getName());
        poi.setPoiType(poiVO.getType());
        poi.setAddress(poiVO.getAddress());
        poi.setTel(poiVO.getTel());
        poi.setShopinfo(poiVO.getShopinfo());
        poi.setLat(poiVO.getLat());
        poi.setLng(poiVO.getLng());
        poi.setPoiOrder(order);
        poi.setStatus(EgoistTableRecordStatusEnum.NORMAL);
        poi.setCreateTime(date);
        return poi;
    }
}
