package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.bean.mysql.EmailSellResponseOthers;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.EmailSellResponseOthersServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Controller
 * @Description: email_sell_response_others
 * @date 2019-04-02 20:12:28
 */
@Controller
@RequestMapping("/emailSellResponseOthersController")
public class EmailSellResponseOthersController {
    private static final Logger logger = LoggerFactory.getLogger(EmailSellResponseOthersController.class);

    @Autowired
    private EmailSellResponseOthersServiceI emailSellResponseOthersService;


    /**
     * email_sell_response_others列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/jeecg/com/emailSellResponseOthersList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(params = "datagrid")
    public void datagrid(EmailSellResponseOthers emailSellResponseOthers, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//        CriteriaQuery cq = new CriteriaQuery(EmailSellResponseOthersEntity.class, dataGrid);
//        //查询条件组装器
//        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, emailSellResponseOthers, request.getParameterMap());
//        cq.add();
//        this.emailSellResponseOthersService.getDataGridReturn(cq, true);
//        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除email_sell_response_others
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(EmailSellResponseOthers emailSellResponseOthers, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();

//        emailSellResponseOthers = systemService.getEntity(EmailSellResponseOthersEntity.class, emailSellResponseOthers.getId());

        message = "email_sell_response_others删除成功";
        try {
            emailSellResponseOthersService.delete(emailSellResponseOthers);
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
    @RequestMapping(params = "doBatchDel")
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
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(EmailSellResponseOthers emailSellResponseOthers, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_others添加成功";
        try {
            emailSellResponseOthersService.save(emailSellResponseOthers);
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
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(EmailSellResponseOthers emailSellResponseOthers, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "email_sell_response_others更新成功";
        try {
            emailSellResponseOthersService.saveOrUpdate(emailSellResponseOthers);
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_others更新失败";
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "emailSellResponseOthersController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }


}
