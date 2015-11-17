package com.qunar.coach.machine.core.model;

/**
 * Created by niuli on 11/16/15.
 */
public class UpdateData {
    private String updateUrl;

    private String version;

    private String isNwIncluded;

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIsNwIncluded() {
        return isNwIncluded;
    }

    public void setIsNwIncluded(String isNwIncluded) {
        this.isNwIncluded = isNwIncluded;
    }

}
