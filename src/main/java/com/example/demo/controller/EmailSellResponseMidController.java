package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.bean.mysql.EmailSellResponseEnd;
import com.example.demo.bean.mysql.EmailSellResponseMid;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.EmailSellResponseMidServiceI;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
	public String list(HttpServletRequest request) {
//		return new ModelAndView("com/jeecg/com/emailSellResponseMidList");

        return "webpage/com/jeecg/com/emailSellResponseMidList";
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param
	 */
	@RequestMapping(value = "datagrid",method = RequestMethod.GET)
    @ResponseBody
	public Object datagrid(EmailSellResponseMid emailSellResponseMid, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(EmailSellResponseMidEntity.class, dataGrid);
//		//查询条件组装器
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, emailSellResponseMid, request.getParameterMap());
//		cq.add();
//		this.emailSellResponseMidService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);



        System.out.println(dataGrid.toString());
        List<EmailSellResponseMid> l = new ArrayList();
        for (int i = 0; i < 24; i++) {
            EmailSellResponseMid e = new EmailSellResponseMid();
//            e.s
            e.setContentCn("sfdf");
            e.setId("id");
            e.setContentResponse("sss");
//            e.setContentType("fdf");
            l.add(e);
        }

        Map<String, Object> stringObjectHashMap = new HashMap<>();


        stringObjectHashMap.put("total", 24);
        stringObjectHashMap.put("rows", l);


        System.out.println(123);

        return stringObjectHashMap;



    }
	
	/**
	 * 删除email_sell_response_mid
	 * 
	 * @return
	 */
	@RequestMapping(value = "doDel",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doDel(EmailSellResponseMid emailSellResponseMid, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
//		emailSellResponseMid = systemService.getEntity(EmailSellResponseMidEntity.class, emailSellResponseMid.getId());
		message = "email_sell_response_mid删除成功";
		try{
			emailSellResponseMidService.delete(emailSellResponseMid);
//			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "email_sell_response_mid删除失败";
//			throw new BusinessException(e.getMessage());
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
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "email_sell_response_mid删除成功";
		try{
			for(String id:ids.split(",")){

                EmailSellResponseMid emailSellResponseMid = new EmailSellResponseMid();
                emailSellResponseMid.setId(id);
                emailSellResponseMidService.delete(emailSellResponseMid);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "email_sell_response_mid删除失败";
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
	public AjaxJson doAdd(EmailSellResponseMid emailSellResponseMid, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "email_sell_response_mid添加成功";
		try{
			emailSellResponseMidService.save(emailSellResponseMid);
		}catch(Exception e){
			e.printStackTrace();
			message = "email_sell_response_mid添加失败";
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
	public AjaxJson doUpdate(EmailSellResponseMid emailSellResponseMid, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "email_sell_response_mid更新成功";
		try {
			emailSellResponseMidService.saveOrUpdate(emailSellResponseMid);
		} catch (Exception e) {
			e.printStackTrace();
			message = "email_sell_response_mid更新失败";
		}
		j.setMsg(message);
		return j;
	}
	

//	/**
//	 * 导入功能跳转
//	 *
//	 * @return
//	 */
//	@RequestMapping(value = "upload")
//	public ModelAndView upload(HttpServletRequest req) {
//		req.setAttribute("controller_name","emailSellResponseMidController");
//		return new ModelAndView("common/upload/pub_excel_upload");
//	}

	
	
}
