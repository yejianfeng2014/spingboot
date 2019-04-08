package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.bean.mysql.EmailSellResponseEnd;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.EmailSellResponseEndServiceI;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;


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
 * @Description: email_sell_response_end
 * @date 2019-04-02 20:12:15
 */
@Controller
@RequestMapping("/emailSellResponseEndController")
@Api(tags = "emailSellResponseEndController", description = "邮件回复模板结束部分的管理功能")
public class EmailSellResponseEndController {
    private static final Logger logger = LoggerFactory.getLogger(EmailSellResponseEndController.class);

    @Autowired
    private EmailSellResponseEndServiceI emailSellResponseEndService;

    /**
     * email_sell_response_end列表 页面跳转
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(HttpServletRequest request) {
//		return new ModelAndView("com/jeecg/com/emailSellResponseEndList");

        return "webpage/emailSellResponseEndList";
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
            int page = dataGrid.getPage();
            int rows = dataGrid.getRows();
            List<EmailSellResponseEnd> emailSellResponseBeggins = emailSellResponseEndService.queryStudentsBySql(page, rows);
            long l1 = emailSellResponseEndService.totalSum();
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
     * 删除email_sell_response_end
     *
     * @return
     */
    @RequestMapping(value = "doDel", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doDel(EmailSellResponseEnd emailSellResponseEnd) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_end删除成功";
        try {
            emailSellResponseEndService.delete(emailSellResponseEnd);
//            j.setMsg(message);
            logger.info("doDel");
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_end删除失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除email_sell_response_end
     *
     * @return
     */
    @RequestMapping(value = "doBatchDel", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_end删除成功";
        try {
            for (String id : ids.split(",")) {
                EmailSellResponseEnd emailSellResponseEnd = new EmailSellResponseEnd();
                emailSellResponseEnd.setId(id);
                emailSellResponseEndService.delete(emailSellResponseEnd);
            }


        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_end删除失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加email_sell_response_end
     *
     * @param
     * @return
     */
    @RequestMapping(value = "doAdd", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doAdd(EmailSellResponseEnd emailSellResponseEnd, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_end添加成功";
        try {
            emailSellResponseEndService.save(emailSellResponseEnd);
            logger.info("doAdd");
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_end添加失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新email_sell_response_end
     *
     * @return
     */
    @RequestMapping(value = "doUpdate", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doUpdate(EmailSellResponseEnd emailSellResponseEnd, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_end更新成功";
        try {
            emailSellResponseEndService.saveOrUpdate(emailSellResponseEnd);

            logger.info("doUpdate");
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_end更新失败";

            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }


}
