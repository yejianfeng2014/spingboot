package com.example.demo.controller;


import com.example.demo.bean.mysql.EmailSellResponseMid;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.EmailSellResponseMidServiceI;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**   
 * @Title: Controller  
 * @Description: email_sell_response_mid
 * @author onlineGenerator
 * @date 2019-04-02 20:11:54
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/emailSellResponseMidController")
@Api(tags = "emailSellResponseMidController", description = "邮件回复模板中间部分的管理功能")
public class EmailSellResponseMidController {
	private static final Logger logger = LoggerFactory.getLogger(EmailSellResponseMidController.class);

	@Autowired
	private EmailSellResponseMidServiceI emailSellResponseMidService;

	/**
	 * email_sell_response_mid列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public String list( ) {
        return "webpage/emailSellResponseMidList";
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param dataGrid
	 * @param
	 */
	@RequestMapping(value = "datagrid",method = RequestMethod.GET)
    @ResponseBody
	public Object datagrid( DataGrid dataGrid) {
		AjaxJson j = new AjaxJson();
		try {
			int page = dataGrid.getPage();
			int rows = dataGrid.getRows();
			List<EmailSellResponseMid> emailSellResponseBeggins = emailSellResponseMidService.queryStudentsBySql(page, rows);
			long l1 = emailSellResponseMidService.totalSum();
			Map<String, Object> stringObjectHashMap = new HashMap<>();
			stringObjectHashMap.put("total", l1);
			stringObjectHashMap.put("rows", emailSellResponseBeggins);
			stringObjectHashMap.put("success",false);
			logger.info("datagrid");
			return stringObjectHashMap;
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);

		}
		j.setMsg("datagrid query success");
		return j;




    }
	
	/**
	 * 删除email_sell_response_mid
	 * 
	 * @return
	 */
	@RequestMapping(value = "doDel",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doDel(EmailSellResponseMid emailSellResponseMid) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "email_sell_response_mid删除成功";
		try{
			emailSellResponseMidService.delete(emailSellResponseMid);
			logger.info("doDel");
		}catch(Exception e){
			e.printStackTrace();
			message = "email_sell_response_mid删除失败";
			j.setSuccess(false);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除email_sell_response_mid
	 * 
	 * @return
	 */
	 @RequestMapping(value = "doBatchDel",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doBatchDel(String ids){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "email_sell_response_mid删除成功";
		try{
			for(String id:ids.split(",")){

                EmailSellResponseMid emailSellResponseMid = new EmailSellResponseMid();
                emailSellResponseMid.setId(id);
                emailSellResponseMidService.delete(emailSellResponseMid);
			}
			logger.info("doBatchDel");
		}catch(Exception e){
			e.printStackTrace();
			message = "email_sell_response_mid删除失败";
			j.setSuccess(false);
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加email_sell_response_mid
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "doAdd",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doAdd(EmailSellResponseMid emailSellResponseMid) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "email_sell_response_mid添加成功";
		try{
			emailSellResponseMidService.save(emailSellResponseMid);
			logger.info("doAdd");
		}catch(Exception e){
			e.printStackTrace();
			message = "email_sell_response_mid添加失败";
			j.setSuccess(false);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新email_sell_response_mid
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "doUpdate",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doUpdate(EmailSellResponseMid emailSellResponseMid) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "email_sell_response_mid更新成功";
		try {
			emailSellResponseMidService.saveOrUpdate(emailSellResponseMid);
			logger.info("doUpdate");
		} catch (Exception e) {
			e.printStackTrace();
			message = "email_sell_response_mid更新失败";
			j.setSuccess(false);
		}
		j.setMsg(message);
		return j;
	}

	
}
