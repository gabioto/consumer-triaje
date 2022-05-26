package com.tdp.ms.triajekafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Header of response.
 */
public class Header {

    @JsonProperty("appName")
    private String appName;
    @JsonProperty("dateTime")
    private String dateTime;
    @JsonProperty("operation")
    private String operation;
    @JsonProperty("resultCode")
    private String resultCode;
    @JsonProperty("message")
    private String message;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
