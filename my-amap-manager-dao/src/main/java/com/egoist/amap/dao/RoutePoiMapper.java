package com.egoist.amap.dao;

import com.egoist.amap.pojo.RoutePoi;
import com.egoist.amap.pojo.RoutePoiExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoutePoiMapper {
    long countByExample(RoutePoiExample example);

    int deleteByExample(RoutePoiExample example);

    int deleteByPrimaryKey(Long idx);

    int insert(RoutePoi record);

    int insertSelective(RoutePoi record);

    List<RoutePoi> selectByExample(RoutePoiExample example);

    RoutePoi selectByPrimaryKey(Long idx);

    int updateByExampleSelective(@Param("record") RoutePoi record, @Param("example") RoutePoiExample example);

    int updateByExample(@Param("record") RoutePoi record, @Param("example") RoutePoiExample example);

    int updateByPrimaryKeySelective(RoutePoi record);

    int updateByPrimaryKey(RoutePoi record);
}