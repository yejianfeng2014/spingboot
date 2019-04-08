package com.example.demo.controller;


import com.example.demo.model.json.AjaxJson;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取模板id 方法
 */


@RestController("/getTemplateIdController")
@Api(tags = "getTemplateIdController", description = "获取模板id")
public class GetModelTemplateIdController {

    private static final Logger logger = LoggerFactory.getLogger(GetModelTemplateIdController.class);


    @RequestMapping(value = "init", method = RequestMethod.GET)
    public String templateInit() {

        // todo 模板初始化的方法，后期考虑加入Redis加快速度
        return "hello entity init";
    }

    /**
     * 获取模板id
     *
     * @return 邮件或者
     */
    @RequestMapping(value = "/id", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson getID(String text, String textFrom) {

        // TODO: 2019/4/1  从数据库读取数据

        String message = null;
        AjaxJson j = new AjaxJson();
        message = "获取模板id成功！！！";
        try {

            logger.info("textFrom:", textFrom, "text:", text);

//            emailSellResponseEndService.delete(emailSellResponseEnd);
            logger.info("getID");

        } catch (Exception e) {
            e.printStackTrace();
            message = "获取模板id失败！！！";

        }

        j.setMsg(message);
        return j;


    }


}
