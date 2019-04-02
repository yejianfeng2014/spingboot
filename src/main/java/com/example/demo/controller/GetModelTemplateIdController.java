package com.example.demo.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取模板id 方法
 */


@RestController("/getTemplateId")
@Api(tags = "通过内容获取模板id", description = "获取模板id")
public class GetModelTemplateIdController {

    @RequestMapping(value = "init",method = RequestMethod.GET)
    public String templateInit() {

        // todo模板初始化的方法，后期考虑加入Redis加快速度
        return "hello entity init";
    }

    /**
     *  获取模板id
     * @return
     *
     * 邮件或者
     *
     */
    @RequestMapping(value = "/id",method = RequestMethod.POST)
   public String getID(String text){


        // TODO: 2019/4/1  从数据库读取数据


        return "";
    }


}
