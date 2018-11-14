package com.egoist.amap.service;

import com.alibaba.fastjson.JSONObject;
import com.egoist.parent.pojo.dto.EgoistResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRoutePoiService {
    @Autowired
    private RoutePoiService routePoiService;

    @Test
    public void testGetAll() {
        EgoistResult result = routePoiService.getAll();
        System.out.println(JSONObject.toJSONString(result));
    }
}
