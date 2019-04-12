package com.example.demo.controller;


import com.example.demo.bean.mysql.AiPaypalResponseTemplatesEntity;
import com.example.demo.bean.mysql.OrderInfoEntity;
import com.example.demo.bean.mysql.RawDataLogEntity;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.service.GetModelTemplateServiceI;
import com.example.demo.service.RawDataLogServiceI;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取模板id 方法
 */


@RestController("/getTemplateIdController")
@Api(tags = "getTemplateIdController", description = "获取模板id")
public class GetModelTemplateIdController {

    private static final Logger logger = LoggerFactory.getLogger(GetModelTemplateIdController.class);


    @Autowired
    private RawDataLogServiceI rawDataLogService;

    @Autowired
    GetModelTemplateServiceI getModelTemplateServiceI;


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
    @RequestMapping(value = "/getTemplateId", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson getID(String msg, String channel, OrderInfoEntity orderInfoEntity) {

        // TODO: 2019/4/1  从数据库读取数据

        Map<String, Object> stringObjectHashMap = new HashMap<>();


        String message = null;
        AjaxJson j = new AjaxJson();
        message = "获取模板id成功！！！";


        String text = msg.toLowerCase().trim();
        String textFrom = channel.toLowerCase().trim();

        boolean support_data_from = true;
        try {
            logger.info("textFrom: " + textFrom);
            logger.info("text:" + text);
            RawDataLogEntity rawDataLogEntity = new RawDataLogEntity();
            rawDataLogEntity.setRawText(text);
            rawDataLogEntity.setSourceType(textFrom);
            rawDataLogService.save(rawDataLogEntity);
            if ("paypal".equals(textFrom.trim())) {
                support_data_from = false;
                List<AiPaypalResponseTemplatesEntity> templateIds_paypal = getModelTemplateServiceI.getTemplateIds_paypal(text.trim());
                stringObjectHashMap.put("rows", templateIds_paypal);
                j.setAttributes(stringObjectHashMap);
            }
            if (support_data_from && "email".equals(textFrom.trim())) {
                support_data_from = false;
            }

            if (support_data_from) {
                message = "不支持的数据源，输入的数据源未paypal 或者email";
                j.setSuccess(false);
            }
            logger.info("getTemplateId");

        } catch (Exception e) {
            e.printStackTrace();
            message = "获取模板id失败！！！";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }

}
