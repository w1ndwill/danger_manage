package com.example.software.bean;

public class Info {
    private int number;
    private String title;
    private String check_type;
    private int info_type;
    private int eme_degree;
    private String issuer;
    private String sec_level;
    private String issue_time;
    private String details;

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

    public String getCheck_type() {
        return check_type;
    }
    public void setCheck_type(String check_type) {
        this.check_type = check_type;
    }

    public int getInfo_type() {
        return info_type;
    }
    public void setInfo_type(int info_type) {
        this.info_type = info_type;
    }

    public int getEme_degree() {
        return eme_degree;
    }
    public void setEme_degree(int eme_degree) {
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

    public String getIssue_time() {
        return issue_time;
    }
    public void setIssue_time(String issue_time) {
        this.issue_time = issue_time;
    }

    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Info{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", check_type='" + check_type + '\'' +
                ", info_type=" + info_type +
                ", eme_degree=" + eme_degree +
                ", issuer='" + issuer + '\'' +
                ", sec_level='" + sec_level + '\'' +
                ", issue_time='" + issue_time + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
