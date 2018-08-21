package com.pxf.project.springboottest.jpa.controller;

import com.pxf.project.springboottest.jpa.interfaces.UserAuthIdSymbolRepository;
import com.pxf.project.springboottest.jpa.model.UserAuthIdSymbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("/jpa")
public class JPATestController {

    @Autowired
    private UserAuthIdSymbolRepository userAuthIdSymbolRepository;

    @RequestMapping("/findSymbol/{authId}")
    @ResponseBody
    public UserAuthIdSymbol findSymbol(@PathVariable("authId") String authId ){
        UserAuthIdSymbol userAuthIdSymbol =  userAuthIdSymbolRepository.findByAuthId(authId);
        System.out.println("userAuthIdSymbol---------->"+userAuthIdSymbol.toString());
        return userAuthIdSymbol;
    }

    @RequestMapping("/thymeleaf/{authId}")
    public String thymeleaf(@PathVariable("authId") String authId , Model model, Locale locale){
        UserAuthIdSymbol userAuthIdSymbol =  userAuthIdSymbolRepository.findByAuthId(authId);
        model.addAttribute("userAuthIdSymbol",userAuthIdSymbol);
        model.addAttribute("greeting", "Hello!");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formattedDate);
        return "hello";
    }

}
