/*
 * ******************************************************
 *   * Copyright (C) 2020 workmac
 *   * This file is part of {project}.
 *   * {project} can not be copied and/or distributed without the
 *   * permission of workmac
 *   ******************************************************
 */


package com.climatesummary.app.filereader;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CsvReaderTest {

    @Test
    public void testCsvReaderFile() throws IOException {
        CsvReader reader = new CsvReaderImpl();
        List<String> strList = reader.readCsvFileAsString();
        Assert.assertEquals("Incorrect csv entires", 1136, strList.size());
    }



}
