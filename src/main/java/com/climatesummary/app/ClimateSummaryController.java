/*
 * ******************************************************
 *   * Copyright (C) 2020 robchu
 *   * This file is part of climatesummary project.
 *   * climatesummary can not be copied and/or distributed without the
 *   * permission of robchu
 *   ******************************************************
 */
package com.climatesummary.app;

import com.climatesummary.app.model.ClimateFilter;
import com.climatesummary.app.model.Station;
import com.climatesummary.app.service.ClimateSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/stations")
public class ClimateSummaryController {

    @Autowired
    ClimateSummaryService<Station, String> climateSummaryService;

    @GetMapping("/allStations")
    public String index(Model model) {
        model.addAttribute("climateFilter", new ClimateFilter());
        return "allStations";

    }

    @PostMapping("/all")
    public ModelAndView showAllStations(@ModelAttribute("climateFilter") ClimateFilter climateFilter, BindingResult result, Model model, HttpServletRequest request) {
        List<Station> stationList = climateSummaryService.getAll(climateFilter);


        model.addAttribute("all_stations", stationList);
        request.getSession().setAttribute("all_stations", stationList);
        return new ModelAndView("allStations");
    }

    @GetMapping("/showDetails")
    public ModelAndView showStationDetails(Model model, HttpServletRequest request, @RequestParam String stationId) {
        int stationIndex = Integer.parseInt(stationId);
        if (stationIndex <= 0) {
            model.addAttribute("error", "Unable to find station");
            return new ModelAndView("error");
        }

        if (request.getSession().getAttribute("all_stations") != null) {
            List<Station> stationList = (List) request.getSession().getAttribute("all_stations");
            Station station = climateSummaryService.getDetails(stationId, stationList);
            model.addAttribute("station_details", station);
        }

        return new ModelAndView("stationDetails");
    }

}