package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.bean.mysql.IntentTemplateRelationsEntity;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.IntentTemplateRelationsServiceI;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @Title: Controller  
 * @Description: intent_template_relations
 * @author onlineGenerator
 * @date 2019-04-08 10:16:52
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/intentTemplateRelationsController")
@Api(tags = "intentTemplateRelationsController", description ="意图和模板的对应关系表")
public class IntentTemplateRelationsController  {
	private static final Logger logger = LoggerFactory.getLogger(IntentTemplateRelationsController.class);

	@Autowired
	private IntentTemplateRelationsServiceI intentTemplateRelationsService;



	/**
	 * intent_template_relations列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value  = "list",method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/com/intentTemplateRelationsList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(value  = "datagrid",method = RequestMethod.GET)
	@ResponseBody
	public Object datagrid(IntentTemplateRelationsEntity intentTemplateRelations, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		AjaxJson j = new AjaxJson();
		try {
			int page = dataGrid.getPage();
			int rows = dataGrid.getRows();
			List<IntentTemplateRelationsEntity> emailSellResponseBeggins = intentTemplateRelationsService.queryStudentsBySql(page, rows);
			long l1 = intentTemplateRelationsService.totalSum();
			Map<String, Object> stringObjectHashMap = new HashMap<>();
			stringObjectHashMap.put("total", l1);
			stringObjectHashMap.put("rows", emailSellResponseBeggins);
			stringObjectHashMap.put("success",true);
			logger.info("datagrid");
			return stringObjectHashMap;
		} catch (Exception e) {
			j.setMsg("datagrid query success");
			e.printStackTrace();
		}
		return j;

	}
	
	/**
	 * 删除intent_template_relations
	 * 
	 * @return
	 */
	@RequestMapping(value  = "doDel",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doDel(IntentTemplateRelationsEntity intentTemplateRelations) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "intent_template_relations删除成功";
		try{
			intentTemplateRelationsService.delete(intentTemplateRelations);

		}catch(Exception e){
			e.printStackTrace();
			message = "intent_template_relations删除失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除intent_template_relations
	 * 
	 * @return
	 */
	 @RequestMapping(value  = "doBatchDel",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "intent_template_relations删除成功";
		try{
			for(String id:ids.split(",")){

				int i = Integer.parseInt(id);
				intentTemplateRelationsService.delete(i);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "intent_template_relations删除失败";
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加intent_template_relations
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value  = "doAdd",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doAdd(IntentTemplateRelationsEntity intentTemplateRelations) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "intent_template_relations添加成功";
		try{
			intentTemplateRelationsService.save(intentTemplateRelations);
		}catch(Exception e){
			e.printStackTrace();
			message = "intent_template_relations添加失败";
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新intent_template_relations
	 * 
	 * @return
	 */
	@RequestMapping(value  = "doUpdate",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doUpdate(IntentTemplateRelationsEntity intentTemplateRelations) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "intent_template_relations更新成功";

		try {
			intentTemplateRelationsService.saveOrUpdate(intentTemplateRelations);
		} catch (Exception e) {
			e.printStackTrace();
			message = "intent_template_relations更新失败";
		}
		j.setMsg(message);
		return j;
	}

}
