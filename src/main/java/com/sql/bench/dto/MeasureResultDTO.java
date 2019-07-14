package com.sql.bench.dto;

public class MeasureResultDTO {

    private String connectionTime;

    private String insertMinTime;
    private String insertMaxTime;
    private String insertAvgTime;
    private String insertTotalTime;

    private String selectMinTime;
    private String selectMaxTime;
    private String selectAvgTime;
    private String selectTotalTime;

    public MeasureResultDTO() {
    }

    public String getInsertMinTime() {
        return insertMinTime;
    }

    public void setInsertMinTime(String insertMinTime) {
        this.insertMinTime = insertMinTime;
    }

    public String getInsertMaxTime() {
        return insertMaxTime;
    }

    public void setInsertMaxTime(String insertMaxTime) {
        this.insertMaxTime = insertMaxTime;
    }

    public String getInsertAvgTime() {
        return insertAvgTime;
    }

    public void setInsertAvgTime(String insertAvgTime) {
        this.insertAvgTime = insertAvgTime;
    }

    public String getInsertTotalTime() {
        return insertTotalTime;
    }

    public void setInsertTotalTime(String insertTotalTime) {
        this.insertTotalTime = insertTotalTime;
    }

    public String getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(String connectionTime) {
        this.connectionTime = connectionTime;
    }

    public String getSelectMinTime() {
        return selectMinTime;
    }

    public void setSelectMinTime(String selectMinTime) {
        this.selectMinTime = selectMinTime;
    }

    public String getSelectMaxTime() {
        return selectMaxTime;
    }

    public void setSelectMaxTime(String selectMaxTime) {
        this.selectMaxTime = selectMaxTime;
    }

    public String getSelectAvgTime() {
        return selectAvgTime;
    }

    public void setSelectAvgTime(String selectAvgTime) {
        this.selectAvgTime = selectAvgTime;
    }

    public String getSelectTotalTime() {
        return selectTotalTime;
    }

    public void setSelectTotalTime(String selectTotalTime) {
        this.selectTotalTime = selectTotalTime;
    }
}
