/*
 * ******************************************************
 *   * Copyright (C) 2020 robchu
 *   * This file is part of climatesummary project.
 *   * climatesummary can not be copied and/or distributed without the
 *   * permission of robchu
 *   ******************************************************
 */
package com.climatesummary.app.filereader;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CsvReaderImpl: Reads csv file and stores each line in a String list
 */
@Component
public class CsvReaderImpl implements CsvReader<String> {

    /**
     * Reads the file and converts it to String list
     *
     * @return
     */
    public List<String> readCsvFileAsString() throws IOException {
        List<String> recordList=new ArrayList<String>();
        InputStream iostream=getClass().getResourceAsStream("/eng-climate-summary.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("eng-climate-summary.csv")));
        String line;
        while((line=reader.readLine())!=null){
            recordList.add(line);
        }
        return recordList;
    }
}
