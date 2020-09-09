/*
 * ******************************************************
 *   * Copyright (C) 2020 robchu
 *   * This file is part of climatesummary project.
 *   * climatesummary can not be copied and/or distributed without the
 *   * permission of robchu
 *   ******************************************************
 */

package com.climatesummary.app.filereader;

import java.io.IOException;
import java.util.List;

/**
 * Interface CsvReader for reading CsvFile
 * @param <T>
 */
public interface CsvReader<T> {
    /**
     * Reads the CSV file and converts it to String List
     * @return
     */
    public List<T> readCsvFileAsString() throws IOException;
}
