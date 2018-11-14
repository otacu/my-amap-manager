package com.egoist.amap.service;

import com.egoist.amap.pojo.RoutePoi;
import com.egoist.parent.pojo.dto.EgoistResult;

import java.util.List;

public interface RoutePoiService {
    /**
     * 获取行程地点列表
     * @return
     */
    EgoistResult getAll();

    /**
     * 保存行程地点
     * @param list
     * @return
     */
    EgoistResult saveAll(List<RoutePoi> list);

    /**
     * 软删除所有行程地点
     * @return
     */
    EgoistResult delAll();
}
