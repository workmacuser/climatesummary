/*
 * ******************************************************
 *   * Copyright (C) 2020 robchu
 *   * This file is part of climatesummary project.
 *   * climatesummary can not be copied and/or distributed without the
 *   * permission of robchu
 *   ******************************************************
 */
package com.climatesummary.app.service;

import com.climatesummary.app.model.ClimateFilter;

import java.util.List;

public interface ClimateSummaryService<T,ID> {

    public List<T> getAll(ClimateFilter climateFilter);
    public T getDetails(ID identifier, List<T> list);
}
