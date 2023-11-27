package com.example.software.bean;

public class Task {
    private String reason;
    private String number;
    private String taskName;
    private String company;
    private String inspectionType;
    private String hiddenDangerCount;
    private String checkcount;
    private String inspector;
    private String startDate;
    private String lng;
    private String lat;

    private String endDate;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getInspectionType() {
        return inspectionType;
    }

    public void setInspectionType(String inspectionType) {
        this.inspectionType = inspectionType;
    }

    public String getHiddenDangerCount() {
        return hiddenDangerCount;
    }

    public void setHiddenDangerCount(String hiddenDangerCount) {
        this.hiddenDangerCount = hiddenDangerCount;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getstartDate() {
        return startDate;
    }

    public void setstartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCheckcount() {
        return checkcount;
    }

    public void setCheckcount(String checkcount) {
        this.checkcount = checkcount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }


}
