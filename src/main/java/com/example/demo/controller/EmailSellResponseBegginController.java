package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.bean.mysql.EmailSellResponseBeggin;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.EmailSellResponseBegginServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
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
public class EmailSellResponseBegginController {

    private static final Logger logger = LoggerFactory.getLogger(EmailSellResponseBegginController.class);

    @Autowired
    private EmailSellResponseBegginServiceI emailSellResponseBegginService;
//	@Autowired
//	private SystemService systemService;


    /**
     * email_sell_response_beggin列表 页面跳转
     *
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(HttpServletRequest request) {
//        return new ModelAndView("com/jeecg/com/emailSellResponseBegginList");

        return "webpage/com/jeecg/com/emailSellResponseBegginList";
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(value = "datagrid",method = RequestMethod.GET)
    @ResponseBody
    public Object datagrid(EmailSellResponseBeggin emailSellResponseBeggin, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(EmailSellResponseBegginEntity.class, dataGrid);
        //查询条件组装器
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, emailSellResponseBeggin, request.getParameterMap());
//		cq.add();


//		this.emailSellResponseBegginService.getDataGridReturn(cq, true);

//		TagUtil.datagrid(response, dataGrid);

        System.out.println(dataGrid.toString());
        List<EmailSellResponseBeggin> l = new ArrayList();
        for (int i=0;i<24;i++){
            EmailSellResponseBeggin e = new EmailSellResponseBeggin();
            e.setContentCn("sfdf");
            e.setId("id");
            e.setContentResponse("sss");
            e.setContentType("fdf");
            l.add(e);
        }

        Map<String, Object> stringObjectHashMap = new HashMap<>();


        stringObjectHashMap.put("total",24);
        stringObjectHashMap.put("rows",l);



        System.out.println(123);

        return stringObjectHashMap;

    }

    /**
     * 删除email_sell_response_beggin
     *
     * @return
     */
    @RequestMapping(value = "del",method = RequestMethod.GET)
    @ResponseBody
    public Object doDel(EmailSellResponseBeggin emailSellResponseBeggin, HttpServletRequest request) {
        String message = null;

        Map resultMap = new HashMap();

//		AjaxJson j = new AjaxJson();
//		emailSellResponseBeggin = systemService.getEntity(EmailSellResponseBegginEntity.class, emailSellResponseBeggin.getId());
        message = "email_sell_response_beggin删除成功";
        try {
            emailSellResponseBegginService.delete(emailSellResponseBeggin);
            resultMap.put("success", true);
            resultMap.put("msg", message);

        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_beggin删除失败";
            resultMap.put("success", false);
            resultMap.put("msg", message);
        }
        return resultMap;
    }

    /**
     * 批量删除email_sell_response_beggin
     *
     * @return
     */
    @RequestMapping(value = "doBatchDel",method = RequestMethod.GET)
    @ResponseBody
    public Object doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        Map j = new HashMap();
        message = "email_sell_response_beggin删除成功";
        try {
//			for(String id:ids.split(",")){
//				EmailSellResponseBegginEntity emailSellResponseBeggin = systemService.getEntity(EmailSellResponseBegginEntity.class,
//				id
//				);
//				emailSellResponseBegginService.delete(emailSellResponseBeggin);
////				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
//			}
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_beggin删除失败";
//			throw new BusinessException(e.getMessage());
        }
//		j.setMsg(message);
        return j;
    }


    /**
     * 添加email_sell_response_beggin
     *
     * @return
     */
    @RequestMapping(value = "doAdd",method = RequestMethod.GET)
    @ResponseBody
    public Object doAdd(EmailSellResponseBeggin emailSellResponseBeggin, HttpServletRequest request) {
        String message = null;
        Map j = new HashMap();
        message = "email_sell_response_beggin添加成功";
        try {
            emailSellResponseBegginService.save(emailSellResponseBeggin);
//			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_beggin添加失败";
//			throw new BusinessException(e.getMessage());
        }
//		j.setMsg(message);
        return j;
    }

    /**
     * 更新email_sell_response_beggin
     *
     * @return
     */
    @RequestMapping(value = "doUpdate",method = RequestMethod.GET)
    @ResponseBody
    public Object doUpdate(EmailSellResponseBeggin emailSellResponseBeggin, HttpServletRequest request) {
        String message = null;
        Object j = new Object();
        message = "email_sell_response_beggin更新成功";
//		EmailSellResponseBegginEntity t = emailSellResponseBegginService.get(EmailSellResponseBegginEntity.class, emailSellResponseBeggin.getId());
        try {
//			MyBeanUtils.copyBeanNotNull2Bean(emailSellResponseBeggin, t);

            emailSellResponseBegginService.saveOrUpdate(emailSellResponseBeggin);
        } catch (Exception e) {
            e.printStackTrace();
            message = "email_sell_response_beggin更新失败";
        }
        return j;
    }


}
