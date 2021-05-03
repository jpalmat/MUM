package edu.mum.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

//    @RequestMapping(value={"/", "/eregistrar","/eregistrar/home"}, method = RequestMethod.GET)
    @GetMapping(value={"/", "/eregistrar","/eregistrar/home"})
    public String displayHomepage() {
        return "home/index";
    }

    @GetMapping(value={"/eregistrar/about"})
    public String displayAboutpage() {
        return "home/about";
    }
}
