package com.admin.dvdstore.api;

import com.admin.dvdstore.dvd.DVDEntry;
import com.admin.dvdstore.producer.DVDProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Robi on 11/21/2018.
 */

@RestController
public class WebController {
    @Autowired
    DVDProducer dvdproducer;

    @RequestMapping("/send")
    public String sendDVD(@RequestParam("title")String title){
        DVDEntry dvdEntry = new DVDEntry(title, 2018, 100);
        dvdproducer.produceDVDEntry(dvdEntry);
        return "Done";
    }
}
