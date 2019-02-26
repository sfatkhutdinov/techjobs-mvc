package org.launchcode.techjobsmvc.controllers;


import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model){
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }


    @RequestMapping(value = "results")
    public String search(Model model, String searchType, String searchTerm){
        model.addAttribute("columns", ListController.columnChoices);
        System.out.println(searchTerm);
        System.out.println(searchType);
        if (searchType.equals("searchTerm")){
            ArrayList<HashMap<String, String>> searchResults = JobData.findByValue(searchTerm);
            model.addAttribute("searchResults", searchResults);
            return "search";
        }else {
            ArrayList<HashMap<String, String>> searchResults = JobData.findByColumnAndValue(searchType, searchTerm);

            model.addAttribute("searchResults", searchResults);

            return "search";
        }
    }

}
