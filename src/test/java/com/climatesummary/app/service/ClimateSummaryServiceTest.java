
package com.climatesummary.app.service;

import com.climatesummary.app.model.ClimateFilter;
import com.climatesummary.app.model.Station;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClimateSummaryServiceTest {

    @Autowired
    ClimateSummaryService<Station,String>climateSummaryService;

    @Test
    public void testGetAllClimateFilterNull() {
        List<Station> results=climateSummaryService.getAll(null);
        Assert.assertEquals("Incorrect Stations", 1135, results.size());
    }
    @Test
    public void testGetAllClimateFilterNotNull1(){
        ClimateFilter climateFilter=new ClimateFilter();
        climateFilter.setFromMonth("02");
        climateFilter.setFromYear("2017");
        climateFilter.setToMonth("12");
        climateFilter.setToYear("2017");
        List<Station> results=climateSummaryService.getAll(climateFilter);
        Assert.assertEquals("Incorrect Stations", 426, results.size());

    }
    @Test
    public void testGetAllClimateFilterNotNull2(){
        ClimateFilter climateFilter=new ClimateFilter();
        climateFilter.setFromMonth("02");
        climateFilter.setFromYear("2017");
        climateFilter.setToMonth("02");
        climateFilter.setToYear("2018");
        List<Station> results=climateSummaryService.getAll(climateFilter);
        Assert.assertEquals("Incorrect Stations", 602, results.size());

    }
}


