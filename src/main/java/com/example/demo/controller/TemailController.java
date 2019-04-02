package com.example.demo.controller;


import com.example.demo.bean.mysql.Temail;
import com.example.demo.service.EmailOperatServiceI;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "eamil_data", description = "邮件内容的的意图标记，增加，删除，查看，修改")
@RequestMapping(value = "temail")
public class TemailController {


    @Autowired
    private EmailOperatServiceI emailOperatServiceI;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(String text) {

//        String lanuage = LanguageDec.getLanuage(text);
        return "this is not done";
    }


    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del(String text) {

//        String lanuage = LanguageDec.getLanuage(text);
        return "this is not done ";
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public Object update(String id,String biaoji,String context,String remark) {
        Map resultMap = new HashMap();
        try {
            Temail temail = new Temail();
            temail.setId(Integer.parseInt(id));
            temail.setBiaoji(biaoji);
            temail.setBeizhu(remark);
            temail.setContent(context);
            emailOperatServiceI.updataEmail(temail);
            resultMap.put(ResultEnum.SUCCESS,true);
            logger.info("update success");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            logger.info("false");

            resultMap.put("success",false);
        }
        return resultMap;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Object all() {
        Map resultMap = new HashMap();
        try {
            List<Temail> all1 = emailOperatServiceI.getALL();
            resultMap.put("all", all1);
            resultMap.put("success", true);

            logger.info("select all success");

        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("success", false);
            logger.info("select all false");
        }
        return resultMap;
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page(String text) {

//        String lanuage = LanguageDec.getLanuage(text);
        return " ";
    }


    @RequestMapping(value = "/mark", method = RequestMethod.GET)
    public Temail getOne2Biaoji() {
        Temail one2Biaoji = emailOperatServiceI.getOne2Biaoji();
        return one2Biaoji;

    }


}
