package com.egoist.amap.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * {"id":"B00141RH20","name":"北京路步行街","type":"购物服务;特色商业街;步行街","location":{"P":23.119908,"O":113.269225,"lng":113.269225,"lat":23.119908},"address":"北京路","tel":"","distance":null,"shopinfo":"0","lat":23.119908,"lng":113.269225}
 */
public class RoutePoiVO implements Serializable {
    private String id;
    private String name;
    private String type;
    private PoiLocationVO location;
    private String address;
    private String tel;
    private BigDecimal distance;
    private String shopinfo;
    private BigDecimal lat;
    private BigDecimal lng;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return location
     */
    public PoiLocationVO getLocation() {
        return location;
    }

    /**
     * @param location location
     */
    public void setLocation(PoiLocationVO location) {
        this.location = location;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return distance
     */
    public BigDecimal getDistance() {
        return distance;
    }

    /**
     * @param distance distance
     */
    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    /**
     * @return shopinfo
     */
    public String getShopinfo() {
        return shopinfo;
    }

    /**
     * @param shopinfo shopinfo
     */
    public void setShopinfo(String shopinfo) {
        this.shopinfo = shopinfo;
    }

    /**
     * @return lat
     */
    public BigDecimal getLat() {
        return lat;
    }

    /**
     * @param lat lat
     */
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    /**
     * @return lng
     */
    public BigDecimal getLng() {
        return lng;
    }

    /**
     * @param lng lng
     */
    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }
}
