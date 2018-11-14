package com.egoist.amap.request;

import com.egoist.amap.vo.RoutePoiVO;

import java.io.Serializable;
import java.util.List;

/**
 * 保存行程请求
 */
public class SaveRoutePoiRequest implements Serializable {
    private List<RoutePoiVO> list;

    /**
     * @return list
     */
    public List<RoutePoiVO> getList() {
        return list;
    }

    /**
     * @param list list
     */
    public void setList(List<RoutePoiVO> list) {
        this.list = list;
    }
}
