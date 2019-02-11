package com.admin.dvdstore.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Robi on 11/27/2018.
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Model showForm(Model model){
        model.addAttribute("title", "form");
        return model;
    }
}
