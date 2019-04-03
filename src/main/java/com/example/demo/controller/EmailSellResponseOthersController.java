package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.bean.mysql.EmailSellResponseOthers;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.EmailSellResponseOthersServiceI;
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
 * @Description: email_sell_response_others
 * @date 2019-04-02 20:12:28
 */
@Controller
@RequestMapping("/emailSellResponseOthersController")
@Api(tags = "emailSellResponseOthersController", description = "邮件回复模板其他内容的管理功能")
public class EmailSellResponseOthersController {
    private static final Logger logger = LoggerFactory.getLogger(EmailSellResponseOthersController.class);

    @Autowired
    private EmailSellResponseOthersServiceI emailSellResponseOthersService;


    /**
     * email_sell_response_others列表 页面跳转
     *
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(HttpServletRequest request) {
        return "webpage/com/jeecg/com/emailSellResponseOthersList";
    }

    /**
     * easyui AJAX请求数据
     *
     * @param dataGrid
     */
    @RequestMapping(value = "datagrid",method = RequestMethod.GET)
    @ResponseBody
    public Object datagrid( DataGrid dataGrid) {
        AjaxJson j = new AjaxJson();
        try {
            int page = dataGrid.getPage();
            int rows = dataGrid.getRows();
            List<EmailSellResponseOthers> emailSellResponseBeggins = emailSellResponseOthersService.queryStudentsBySql(page, rows);
            long l1 = emailSellResponseOthersService.totalSum();
            Map<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("total", l1);
            stringObjectHashMap.put("rows", emailSellResponseBeggins);
            stringObjectHashMap.put("success",false);

            logger.info("datagrid");
            return stringObjectHashMap;
        } catch (Exception e) {
            j.setMsg("datagrid query success");
            e.printStackTrace();
        }
        return j;


    }

    /**
     * 删除email_sell_response_others
     *
     * @return
     */
    @RequestMapping(value = "doDel",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doDel(EmailSellResponseOthers emailSellResponseOthers, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();

        message = "email_sell_response_others删除成功";
        try {
            emailSellResponseOthersService.delete(emailSellResponseOthers);
            logger.info("doDel");
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_others删除失败";
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除email_sell_response_others
     *
     * @return
     */
    @RequestMapping(value = "doBatchDel",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_others删除成功";
        try {
            for (String id : ids.split(",")) {

                EmailSellResponseOthers emailSellResponseOthers = new EmailSellResponseOthers();
                    emailSellResponseOthers.setId(id);

                emailSellResponseOthersService.delete(emailSellResponseOthers);
            }

           logger.info("doBatchDel");
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_others删除失败";
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加email_sell_response_others
     *
     * @param
     * @return
     */
    @RequestMapping(value = "doAdd",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doAdd(EmailSellResponseOthers emailSellResponseOthers, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_others添加成功";
        try {
            emailSellResponseOthersService.save(emailSellResponseOthers);
            logger.info("doAdd");
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_others添加失败";
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新email_sell_response_others
     *
     * @param
     * @return
     */
    @RequestMapping(value = "doUpdate",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doUpdate(EmailSellResponseOthers emailSellResponseOthers, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_others更新成功";
        try {
            emailSellResponseOthersService.saveOrUpdate(emailSellResponseOthers);
            logger.info("doUpdate");

        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_others更新失败";
        }
        j.setMsg(message);
        return j;
    }


//    /**
//     * 导入功能跳转
//     *
//     * @return
//     */
//    @RequestMapping(value = "upload",method = RequestMethod.GET)
//    public ModelAndView upload(HttpServletRequest req) {
//        req.setAttribute("controller_name", "emailSellResponseOthersController");
//        return new ModelAndView("common/upload/pub_excel_upload");
//    }


}
