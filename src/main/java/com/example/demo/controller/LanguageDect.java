package com.example.demo.controller;

import com.example.demo.utils.LanguageDec;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@Api(tags = "languageDector", description = "语言种类检测 ")
@RequestMapping(value = "language")
public class LanguageDect {

    @RequestMapping(value = "/detect", method = RequestMethod.GET)
    public String home(String text) {

        String lanuage = LanguageDec.getLanuage(text);
        return lanuage;
    }

}
