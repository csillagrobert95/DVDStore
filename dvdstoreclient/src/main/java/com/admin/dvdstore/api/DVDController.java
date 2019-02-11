package com.admin.dvdstore.api;

import com.admin.dvdstore.dvd.DVDEntry;
import com.admin.dvdstore.producer.DVDProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * Created by Robi on 11/27/2018.
 */
@Controller
public class DVDController {
    @Autowired
    DVDProducer dvdproducer;

    @PostMapping("add_dvd")
    public String addDVD(@ModelAttribute @Valid DVDEntry dvdEntry, BindingResult errors, SessionStatus status){
        if (errors.hasErrors()){
            return "admin/add_form";
        }
        dvdproducer.produceDVDEntry(dvdEntry);
        status.setComplete();
        return "redirect:index";
    }
}
