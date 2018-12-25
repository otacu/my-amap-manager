# my-amap-manager
高德地图后台管理

CREATE TABLE `tb_route_poi` (
  `idx` bigint(19) unsigned NOT NULL AUTO_INCREMENT COMMENT '表自增id',
  `poi_id` varchar(20) DEFAULT NULL COMMENT '地点id',
  `poi_name` varchar(100) DEFAULT NULL COMMENT '地点名称',
  `poi_type` varchar(200) DEFAULT NULL COMMENT '地点类型',
  `address` varchar(300) DEFAULT NULL COMMENT '地点地址',
  `tel` varchar(100) DEFAULT NULL COMMENT '电话',
  `shopinfo` varchar(100) DEFAULT NULL,
  `lng` decimal(10,6) unsigned DEFAULT NULL COMMENT '纬度',
  `lat` decimal(10,6) unsigned DEFAULT NULL COMMENT '经度',
  `poi_order` int(10) unsigned DEFAULT NULL COMMENT '显示序号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `status` smallint(1) unsigned DEFAULT NULL COMMENT '记录状态（0：已删除，1：正常）',
  PRIMARY KEY (`idx`)
) COMMENT='行程地点表';
