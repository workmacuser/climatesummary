/*
 * ******************************************************
 *   * Copyright (C) 2020 robchu
 *   * This file is part of climatesummary project.
 *   * climatesummary can not be copied and/or distributed without the
 *   * permission of robchu
 *   ******************************************************
 */
package com.climatesummary.app.service;

import com.climatesummary.app.filereader.CsvReader;
import com.climatesummary.app.model.ClimateFilter;
import com.climatesummary.app.model.Station;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;

@Service
public class ClimateSummaryServiceImpl implements ClimateSummaryService<Station, String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClimateSummaryService.class);

    @Autowired
    CsvReader<String> csvReader;

    /**
     * getAll() method reads the CSV file and converts that to the
     * list of station objects.
     *
     * @param climateFilter Criteria on which results needs to filtered
     * @return List of station object
     */
    @Override
    public List<Station> getAll(ClimateFilter climateFilter) {
        List<Station> stationList = new ArrayList<>();
        try {
            List<String> readCsvList = csvReader.readCsvFileAsString();
            int length = readCsvList.size();
            int count = 0;
            for (String line : readCsvList.subList(1, length)) {
                String[] row = line.split(",");
                LOGGER.info(String.format("getAll(): Creating station object from row %s: \n", line));
                Station station = Station.fromStringRow(row);
                station.setStationId(++count);
                stationList.add(station);
            }
            LOGGER.info("getAll(): Completed reading all rows");
            if (climateFilter != null) {
                LOGGER.info("filtering results based on Climate obj");
                List<Station> filteredResults = filterResults(climateFilter, stationList);
                if (filteredResults != null) {
                    return filteredResults;
                }


            }
        } catch (IOException io) {
            LOGGER.error("getAll() threw IO exception", io);
        }
        return stationList;
    }

    /**
     * geDetails returns Station object from list based on an index
     *
     * @param identifier Index of an element as string
     * @param list       List of Stations
     * @return Station object from the list
     */
    @Override
    public Station getDetails(String identifier, List<Station> list) {
        int index = Integer.parseInt(identifier);
        if (index <= 0) {
            return null;
        }
        index--;
        if (index > list.size()) {
            return null;
        }
        return list.get(index);
    }

    public List<Station> filterResults(ClimateFilter climateFilter, List<Station> result) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if(climateFilter.getFromMonth().equals("0") || climateFilter.getFromYear().equals("0") || climateFilter.getToMonth().equals("0")||climateFilter.getToYear().equals("0")){
                return null;
            }
            Date fromDate = dateFormat.parse(String.format("01/%s/%s", climateFilter.getFromMonth(), climateFilter.getFromYear()));
            Date toDate = dateFormat.parse(String.format("01/%s/%s", climateFilter.getToMonth(), climateFilter.getToYear()));
            Predicate<Station> byDate = station -> (station.getDate().after(fromDate) && station.getDate().before(toDate));
            List<Station> filteredResults = result.stream().filter(byDate).collect(Collectors.toList());
            if (filteredResults.size() > 0) {
                return filteredResults;
            }
        } catch (ParseException parseException) {
            LOGGER.error("Unable to filter list",parseException);
        }
        return null;
    }


}
