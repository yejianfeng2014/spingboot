package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.bean.mysql.EmailSellResponseBeggin;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.EmailSellResponseBegginServiceI;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Controller
 * @Description: email_sell_response_beggin
 * @date 2019-04-02 16:40:07
 */
@Controller
@RequestMapping("/emailSellResponseBegginController")
@Api(tags = "emailSellResponseBegginController", description = "邮件回复模板开始部分的管理功能")
public class EmailSellResponseBegginController {

    private static final Logger logger = LoggerFactory.getLogger(EmailSellResponseBegginController.class);

    @Autowired
    private EmailSellResponseBegginServiceI emailSellResponseBegginService;

    /**
     * email_sell_response_beggin列表 页面跳转
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "webpage/emailSellResponseBegginList";
    }

    /**
     * easyui AJAX请求数据
     *
     * @param dataGrid
     */
    @RequestMapping(value = "datagrid", method = RequestMethod.GET)
    @ResponseBody
    public Object datagrid(DataGrid dataGrid) {
        AjaxJson j = new AjaxJson();
        try {
            Map<String, Object> stringObjectHashMap = getStringObjectMap(dataGrid);

            logger.info("datagrid");
            return stringObjectHashMap;
        } catch (Exception e) {
            j.setMsg("datagrid query success");
            j.setSuccess(false);
            e.printStackTrace();
        }
        return j;
    }

    public Map<String, Object> getStringObjectMap(DataGrid dataGrid) {
        int page = dataGrid.getPage();
        int rows = dataGrid.getRows();
        List<EmailSellResponseBeggin> emailSellResponseBeggins = emailSellResponseBegginService.queryStudentsBySql(page, rows);
        long l1 = emailSellResponseBegginService.totalSum();
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("total", l1);
        stringObjectHashMap.put("rows", emailSellResponseBeggins);
        stringObjectHashMap.put("success",true);
        return stringObjectHashMap;
    }

    /**
     * 删除email_sell_response_beggin
     *
     * @return
     */
    @RequestMapping(value = "doDel", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doDel(EmailSellResponseBeggin emailSellResponseBeggin, HttpServletRequest request) {
        String message = null;

        AjaxJson j = new AjaxJson();
        message = "email_sell_response_beggin删除成功";
        try {
            emailSellResponseBegginService.delete(emailSellResponseBeggin);
            j.setMsg(message);
            logger.info("doDel");
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_beggin删除失败";
            j.setMsg(message);
            j.setSuccess(false);
        }
        return j;
    }

    /**
     * 批量删除email_sell_response_beggin
     *
     * @return
     */
    @RequestMapping(value = "doBatchDel", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doBatchDel(String ids) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_beggin删除成功";
        try {
			for(String id:ids.split(",")){
                EmailSellResponseBeggin emailSellResponseBeggin = new EmailSellResponseBeggin();
                emailSellResponseBeggin.setId(id);
                emailSellResponseBegginService.delete(emailSellResponseBeggin);
			}
		j.setMsg(message);
            logger.info("doBatchDel");
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_beggin删除失败";
            j.setMsg(message);
        }
        return j;
    }


    /**
     * 添加email_sell_response_beggin
     *
     * @return
     */
    @RequestMapping(value = "doAdd", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doAdd(EmailSellResponseBeggin emailSellResponseBeggin, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_beggin添加成功";
        try {
            emailSellResponseBegginService.save(emailSellResponseBeggin);

            logger.info("doAdd");
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_beggin添加失败";
            j.setSuccess(false);
        }

        j.setMsg(message);
        return j;
    }

    /**
     * 更新email_sell_response_beggin
     *
     * @return
     */
    @RequestMapping(value = "doUpdate", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doUpdate(EmailSellResponseBeggin emailSellResponseBeggin) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_beggin更新成功";
        try {
            emailSellResponseBegginService.saveOrUpdate(emailSellResponseBeggin);
            logger.info("doUpdate");

        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_beggin更新失败";

            j.setSuccess(false);
        }

        j.setMsg(message);
        return j;
    }


}
