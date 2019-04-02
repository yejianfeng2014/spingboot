package com.example.demo.utils;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import com.example.demo.controller.LanguageDect;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;

public  class LanguageDec {

    public static String getLanuage(String text) {

        // 设置语言优先级
         HashMap priorMap = new HashMap();
        priorMap.put("en", 1000D);
        priorMap.put("th", 100D);
        priorMap.put("fr", 10D);
        priorMap.put("zh-cn", 5D);
        priorMap.put("zh-tw", 4D);

        String result = "";
        Detector detect;
        try {
            int size = DetectorFactory.getLangList().size();
            if (size  == 0){
                DetectorFactory.loadProfile(new File(LanguageDect.class.getResource("/profiles").toURI()));
            }else {

            }

            detect = DetectorFactory.create();
            // 打印出支持的语言列表
            System.out.println(DetectorFactory.getLangList());

             detect.setPriorMap(priorMap);
            // 设置文本
            detect.append(text);
            // detect.append(T2);

            // 解析，得到语言
            String lang = detect.detect();

            System.out.println(detect.getProbabilities());

            return lang;

            // 打印出解析的语言比例，如：[zh-cn:0.5714248723691703, en:0.4285738367405386]

        } catch (LangDetectException e) {

            if (e.getMessage() != null && "no features in text".equals(e.getMessage().trim())) {
                System.out.println("无法识别该语言！");
            }
            e.printStackTrace();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return result;

    }


}
