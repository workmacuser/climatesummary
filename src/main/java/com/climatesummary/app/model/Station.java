/*
 * ******************************************************
 *   * Copyright (C) 2020 robchu
 *   * This file is part of climatesummary project.
 *   * climatesummary can not be copied and/or distributed without the
 *   * permission of robchu
 *   ******************************************************
 */
package com.climatesummary.app.model;


import com.climatesummary.app.utils.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Station Value object. This holds different data for each station
 */
public class Station {

    private int stationId;
    private String stationName;
    private String province;
    private Date date;
    private double meanTemp;
    private double highestMonthlyMaxTemp;
    private double lowestMonthlyMinTemp;

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMeanTemp() {
        return meanTemp;
    }

    public void setMeanTemp(double meanTemp) {
        this.meanTemp = meanTemp;
    }

    public double getHighestMonthlyMaxTemp() {
        return highestMonthlyMaxTemp;
    }

    public void setHighestMonthlyMaxTemp(double highestMonthlyMaxTemp) {
        this.highestMonthlyMaxTemp = highestMonthlyMaxTemp;
    }

    public double getLowestMonthlyMinTemp() {
        return lowestMonthlyMinTemp;
    }

    public void setLowestMonthlyMinTemp(double lowestMonthlyMinTemp) {
        this.lowestMonthlyMinTemp = lowestMonthlyMinTemp;
    }

    public static Station fromStringRow(String[] row) {
        Station station = new Station();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int rowSize = row.length;
        for (int count = 0; count < rowSize; count++) {
            if (count == 0) {
                station.setStationName(row[count]);
            }
            if (count == 1) {
                station.setProvince(row[count]);
            }
            if (count == 2) {
                try {
                    station.setDate(dateFormat.parse(row[count]));
                } catch (ParseException pe) {
                    Constants.GENERIC_LOGGER.error("Unable to parse date",pe);
                }
            }
            if (count == 3 && (row[count] != null && !row[count].equals(Constants.EMPTY_STRING))) {

                station.setMeanTemp(Double.parseDouble(row[count]));
            }
            if (count == 4 && (row[count] != null && !row[count].equals(Constants.EMPTY_STRING))) {
                station.setHighestMonthlyMaxTemp(Double.parseDouble(row[count]));
            }
            if (count == 5 && (row[count] != null && !row[count].equals(Constants.EMPTY_STRING))) {
                station.setLowestMonthlyMinTemp(Double.parseDouble(row[count]));
            }
        }

        return station;
    }
}
