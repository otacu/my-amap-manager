package com.egoist.amap.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class PoiLocationVO implements Serializable {
    @JsonProperty(value = "P")
    private BigDecimal p;

    @JsonProperty(value = "O")
    private BigDecimal o;

    private BigDecimal lng;

    private BigDecimal lat;

    /**
     * @return p
     */
    public BigDecimal getP() {
        return p;
    }

    /**
     * @param p p
     */
    public void setP(BigDecimal p) {
        this.p = p;
    }

    /**
     * @return o
     */
    public BigDecimal getO() {
        return o;
    }

    /**
     * @param o o
     */
    public void setO(BigDecimal o) {
        this.o = o;
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
}
