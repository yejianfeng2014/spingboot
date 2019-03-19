package com.example.demo.controller;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import static com.example.demo.utils.LanguageDec.getLanuage;


@RestController
@Api(tags = "languageDector", description = "语言种类检测 ")
@RequestMapping(value = "language")
public class LanguageDect {

    @RequestMapping(value = "/detect", method = RequestMethod.GET)
    public String home(String text) {

        String lanuage = getLanuage(text);

        return lanuage;

    }



}
