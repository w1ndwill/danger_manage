package com.example.software.bean;

import javax.xml.crypto.Data;
import java.util.Date;

public class Info {
    private int number;
    private String title;
    private String info_type;
    private String eme_degree;
    private String issuer;
    private String sec_level;
    private Date issue_time;
    private String details;
    private int scope;

    //补全getter和setter方法
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo_type() {
        return info_type;
    }
    public void setInfo_type(String info_type) {
        this.info_type = info_type;
    }

    public String getEme_degree() {
        return eme_degree;
    }
    public void setEme_degree(String eme_degree) {
        this.eme_degree = eme_degree;
    }

    public String getIssuer() {
        return issuer;
    }
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getSec_level() {
        return sec_level;
    }
    public void setSec_level(String sec_level) {
        this.sec_level = sec_level;
    }

    public Date getIssue_time() {
        return issue_time;
    }
    public void setIssue_time(Date issue_time) {
        this.issue_time = issue_time;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public int getScope() {
        return scope;
    }
    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "Info{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", info_type=" + info_type +
                ", eme_degree=" + eme_degree +
                ", issuer='" + issuer + '\'' +
                ", sec_level='" + sec_level + '\'' +
                ", issue_time='" + issue_time + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
