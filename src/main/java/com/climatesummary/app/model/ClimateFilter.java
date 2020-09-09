/*
 * ******************************************************
 *   * Copyright (C) 2020 robchu
 *   * This file is part of climatesummary project.
 *   * climatesummary can not be copied and/or distributed without the
 *   * permission of robchu
 *   ******************************************************
 */
package com.climatesummary.app.model;

/**
 * Utility value object which holds the station filtering criteria
 */
public class ClimateFilter {

    private String fromYear;
    private String fromMonth;
    private String toYear;
    private String toMonth;

    public String getToYear() {
        return toYear;
    }

    public void setToYear(String toYear) {
        this.toYear = toYear;
    }

    public String getToMonth() {
        return toMonth;
    }

    public void setToMonth(String toMonth) {
        this.toMonth = toMonth;
    }

    public String getFromYear() {
        return fromYear;
    }

    public void setFromYear(String fromYear) {
        this.fromYear = fromYear;
    }

    public String getFromMonth() {
        return fromMonth;
    }

    public void setFromMonth(String fromMonth) {
        this.fromMonth = fromMonth;
    }
}
