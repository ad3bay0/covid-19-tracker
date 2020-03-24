package com.ad3bay0.covid19tracker.controllers;

import java.util.List;

import com.ad3bay0.covid19tracker.models.LocationStats;
import com.ad3bay0.covid19tracker.services.ApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController
 */

 @Controller
public class HomeController {

    @Autowired
    ApiService apiService;

    @GetMapping("/")
    public String home(Model model){

        List<LocationStats> allStats = apiService.getAllStats();
        int totalCases = allStats.stream().mapToInt(stat->stat.getLatestCases()).sum();

        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalCases", totalCases);


        return "home";
    }
    
}