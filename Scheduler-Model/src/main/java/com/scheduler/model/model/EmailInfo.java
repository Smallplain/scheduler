package com.scheduler.model.model;

import java.util.Date;

public class EmailInfo {
    private Integer emailId;

    private String emailType;

    private String emailName;

    private String emailContent;

    private String emaiTitle;

    private Integer senderId;

    private Integer status;

    private Byte isDeleted;

    private Date emailSendTime;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType == null ? null : emailType.trim();
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName == null ? null : emailName.trim();
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent == null ? null : emailContent.trim();
    }

    public String getEmaiTitle() {
        return emaiTitle;
    }

    public void setEmaiTitle(String emaiTitle) {
        this.emaiTitle = emaiTitle == null ? null : emaiTitle.trim();
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getEmailSendTime() {
        return emailSendTime;
    }

    public void setEmailSendTime(Date emailSendTime) {
        this.emailSendTime = emailSendTime;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}