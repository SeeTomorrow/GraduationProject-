package com.dz.bestnew.po.generator;

public class Extent {
    private Integer extentId;

    private String extentName;

    public Integer getExtentId() {
        return extentId;
    }

    public void setExtentId(Integer extentId) {
        this.extentId = extentId;
    }

    public String getExtentName() {
        return extentName;
    }

    public void setExtentName(String extentName) {
        this.extentName = extentName == null ? null : extentName.trim();
    }
}