package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.bean.mysql.AiPaypalResponseTemplatesEntity;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.AiPaypalResponseTemplatesServiceI;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Controller
 * @Description: ai_paypal_response_templates
 * @date 2019-04-10 15:08:35
 */
@Controller
@RequestMapping("/aiPaypalResponseTemplatesController")
@Api(tags = "aiPaypalResponseTemplatesController", description = "paypal回复模板")
public class AiPaypalResponseTemplatesController {
    private static final Logger logger = LoggerFactory.getLogger(AiPaypalResponseTemplatesController.class);

    @Autowired
    private AiPaypalResponseTemplatesServiceI aiPaypalResponseTemplatesService;


    /**
     * ai_paypal_response_templates列表 页面跳转
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/jeecg/com/aiPaypalResponseTemplatesList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(value = "datagrid", method = RequestMethod.GET)
    @ResponseBody
    public Object datagrid(AiPaypalResponseTemplatesEntity aiPaypalResponseTemplates, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

        AjaxJson j = new AjaxJson();
        try {
            int page = dataGrid.getPage();
            int rows = dataGrid.getRows();
            List<AiPaypalResponseTemplatesEntity> emailSellResponseBeggins = aiPaypalResponseTemplatesService.queryStudentsBySql(page, rows);
            long l1 = aiPaypalResponseTemplatesService.totalSum();
            Map<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("total", l1);
            stringObjectHashMap.put("rows", emailSellResponseBeggins);
            stringObjectHashMap.put("success", true);
            logger.info("datagrid");
            return stringObjectHashMap;
        } catch (Exception e) {
            j.setMsg("datagrid query success");
            e.printStackTrace();
            j.setSuccess(false);
        }
        return j;


    }

    /**
     * 删除ai_paypal_response_templates
     *
     * @return
     */
    @RequestMapping(value = "doDel", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doDel(AiPaypalResponseTemplatesEntity aiPaypalResponseTemplates, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "ai_paypal_response_templates删除成功";
        try {
            aiPaypalResponseTemplatesService.delete(aiPaypalResponseTemplates);
            logger.info("doDel");
        } catch (Exception e) {
            e.printStackTrace();
            message = "ai_paypal_response_templates删除失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除ai_paypal_response_templates
     *
     * @return
     */
    @RequestMapping(value = "doBatchDel", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "ai_paypal_response_templates删除成功";
        try {
            for (String id : ids.split(",")) {
                int i = Integer.parseInt(id);
                aiPaypalResponseTemplatesService.delete(i);
            }
            logger.info("doBatchDel");
        } catch (Exception e) {
            e.printStackTrace();
            message = "ai_paypal_response_templates删除失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加ai_paypal_response_templates
     *
     * @param
     * @return
     */
    @RequestMapping(value = "doAdd", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doAdd(AiPaypalResponseTemplatesEntity aiPaypalResponseTemplates, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "ai_paypal_response_templates添加成功";
        try {
            aiPaypalResponseTemplatesService.save(aiPaypalResponseTemplates);
            logger.info("doAdd");
        } catch (Exception e) {
            e.printStackTrace();
            message = "ai_paypal_response_templates添加失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新ai_paypal_response_templates
     *
     * @param
     * @return
     */
    @RequestMapping(value = "doUpdate", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doUpdate(AiPaypalResponseTemplatesEntity aiPaypalResponseTemplates, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "ai_paypal_response_templates更新成功";
        try {
            aiPaypalResponseTemplatesService.saveOrUpdate(aiPaypalResponseTemplates);
            logger.info("doUpdate");
        } catch (Exception e) {
            e.printStackTrace();
            message = "ai_paypal_response_templates更新失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }


}
