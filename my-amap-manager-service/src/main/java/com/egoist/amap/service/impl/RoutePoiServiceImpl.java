package com.egoist.amap.service.impl;

import com.egoist.amap.dao.RoutePoiMapper;
import com.egoist.amap.pojo.RoutePoi;
import com.egoist.amap.pojo.RoutePoiExample;
import com.egoist.amap.service.RoutePoiService;
import com.egoist.parent.common.enums.EgoistTableRecordStatusEnum;
import com.egoist.parent.common.utils.collection.EgoistCollectionUtil;
import com.egoist.parent.pojo.dto.EgoistResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutePoiServiceImpl implements RoutePoiService {
    @Autowired
    private RoutePoiMapper routePoiMapper;

    /**
     * 获取行程地点列表
     *
     * @return
     */
    @Override
    public EgoistResult getAll() {
        RoutePoiExample example = new RoutePoiExample();
        RoutePoiExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(EgoistTableRecordStatusEnum.NORMAL);
        example.setOrderByClause("poi_order asc");
        List<RoutePoi> list = routePoiMapper.selectByExample(example);
        return EgoistResult.ok(list);
    }

    /**
     * 保存行程地点
     *
     * @param list
     * @return
     */
    @Override
    public EgoistResult saveAll(List<RoutePoi> list) {
        if (EgoistCollectionUtil.isNotEmpty(list)) {
            list.forEach(poi -> {
                routePoiMapper.insert(poi);
            });
        }
        return EgoistResult.ok();
    }

    /**
     * 软删除所有行程地点
     *
     * @return
     */
    @Override
    public EgoistResult delAll() {
        RoutePoiExample example = new RoutePoiExample();
        RoutePoiExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(EgoistTableRecordStatusEnum.NORMAL);
        List<RoutePoi> list = routePoiMapper.selectByExample(example);
        if (EgoistCollectionUtil.isNotEmpty(list)) {
            list.forEach(poi -> {
                poi.setStatus(EgoistTableRecordStatusEnum.DELETE);
                routePoiMapper.updateByPrimaryKey(poi);
            });
        }
        return EgoistResult.ok();
    }
}
