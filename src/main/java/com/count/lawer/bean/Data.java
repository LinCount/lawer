package com.count.lawer.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
//资料实体
public class Data implements Serializable {
    private String dataId;//资料id
    private String lawerId;//律师id
    private String userId;//用户id
    private String dataContent;//用户要求内容
    private Date dataTime;//资料时间
    private String dataUrl;//用户提交资料
    private String backDataUrl;//律师返回资料
    private String backSug;//律师返回建议
    private BigDecimal replay;//赏金
    private String appeal;//是否申诉

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getLawerId() {
        return lawerId;
    }

    public void setLawerId(String lawerId) {
        this.lawerId = lawerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getBackDataUrl() {
        return backDataUrl;
    }

    public void setBackDataUrl(String backDataUrl) {
        this.backDataUrl = backDataUrl;
    }

    public String getBackSug() {
        return backSug;
    }

    public void setBackSug(String backSug) {
        this.backSug = backSug;
    }

    public BigDecimal getReplay() {
        return replay;
    }

    public void setReplay(BigDecimal replay) {
        this.replay = replay;
    }

    public String getAppeal() {
        return appeal;
    }

    public void setAppeal(String appeal) {
        this.appeal = appeal;
    }
}
