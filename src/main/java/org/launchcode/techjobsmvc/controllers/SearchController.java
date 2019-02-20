package org.launchcode.techjobsmvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model){
        model.addAttribute("column", ListController.columnChoices);
        return "search";
    }

    //TODO #1 - Create handler to process search request and display results

}
