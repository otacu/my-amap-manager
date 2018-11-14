package com.egoist.amap;

import com.alibaba.fastjson.JSONObject;
import com.egoist.parent.common.utils.http.EgoistOkHttp3Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyAmapManagerApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public void testHttp() {
        String url = "https://blog.csdn.net/ghost_chou/phoenix/comment/list/78056852?page=1&tree_type=1";
        Map<String, Object> map = new HashMap<>();
        try {
            JSONObject json = EgoistOkHttp3Util.post(url, map);
            System.out.println("##########" + json.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
