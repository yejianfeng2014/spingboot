package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.bean.mysql.EmailSellResponseEnd;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.EmailSellResponseEndServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @Title: Controller  
 * @Description: email_sell_response_end
 * @author onlineGenerator
 * @date 2019-04-02 20:12:15
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/emailSellResponseEndController")
public class EmailSellResponseEndController {
	private static final Logger logger = LoggerFactory.getLogger(EmailSellResponseEndController.class);

	@Autowired
	private EmailSellResponseEndServiceI emailSellResponseEndService;



	/**
	 * email_sell_response_end列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/com/emailSellResponseEndList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(EmailSellResponseEnd emailSellResponseEnd, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(EmailSellResponseEndEntity.class, dataGrid);
		//查询条件组装器
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, emailSellResponseEnd, request.getParameterMap());
//		cq.add();
//		this.emailSellResponseEndService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除email_sell_response_end
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EmailSellResponseEnd emailSellResponseEnd, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
//		emailSellResponseEnd = systemService.getEntity(EmailSellResponseEndEntity.class, emailSellResponseEnd.getId());

		message = "email_sell_response_end删除成功";
		try{
			emailSellResponseEndService.delete(emailSellResponseEnd);
//			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "email_sell_response_end删除失败";
//			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除email_sell_response_end
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "email_sell_response_end删除成功";
		try{
			for(String id:ids.split(",")){
                EmailSellResponseEnd emailSellResponseEnd = new EmailSellResponseEnd();
                emailSellResponseEnd.setId(id);
                emailSellResponseEndService.delete(emailSellResponseEnd);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "email_sell_response_end删除失败";
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
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EmailSellResponseEnd emailSellResponseEnd, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "email_sell_response_end添加成功";
		try{
			emailSellResponseEndService.save(emailSellResponseEnd);
		}catch(Exception e){
			e.printStackTrace();
			message = "email_sell_response_end添加失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新email_sell_response_end
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EmailSellResponseEnd emailSellResponseEnd, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "email_sell_response_end更新成功";
		try {
			emailSellResponseEndService.saveOrUpdate(emailSellResponseEnd);
		} catch (Exception e) {
			e.printStackTrace();
			message = "email_sell_response_end更新失败";
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
		req.setAttribute("controller_name","emailSellResponseEndController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	
}
