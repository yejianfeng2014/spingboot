package com.example.demo.controller;
import com.example.demo.bean.mysql.IntentPhraseEntity;
import com.example.demo.model.json.AjaxJson;
import java.util.List;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.IntentPhraseServiceI;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;


import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @Title: Controller  
 * @Description: intent_phrase
 * @author onlineGenerator
 * @date 2019-04-08 10:17:37
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/intentPhraseController")
@Api(tags = "intentPhraseController", description = "意图短语的增删改，查")
public class IntentPhraseController  {
	private static final Logger logger = LoggerFactory.getLogger(IntentPhraseController.class);

	@Autowired
	private IntentPhraseServiceI intentPhraseService;
	/**
	 * intent_phrase列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(value  = "list",method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("com/jeecg/com/intentPhraseList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param dataGrid
	 */
	@RequestMapping(value = "datagrid" ,method = RequestMethod.GET)
	@ResponseBody
	public Object datagrid( DataGrid dataGrid) {

		AjaxJson j = new AjaxJson();
		try {
			int page = dataGrid.getPage();
			int rows = dataGrid.getRows();
			List<IntentPhraseEntity> emailSellResponseBeggins = intentPhraseService.queryStudentsBySql(page, rows);
			long l1 = intentPhraseService.totalSum();
			Map<String, Object> stringObjectHashMap = new HashMap<>();
			stringObjectHashMap.put("total", l1);
			stringObjectHashMap.put("rows", emailSellResponseBeggins);
			stringObjectHashMap.put("success",true);
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
	 * 删除intent_phrase
	 * 
	 * @return
	 */
	@RequestMapping(value  = "doDel",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doDel(IntentPhraseEntity intentPhrase) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "intent_phrase删除成功";
		try{
			intentPhraseService.delete(intentPhrase);
		}catch(Exception e){
			e.printStackTrace();
			message = "intent_phrase删除失败";
			j.setSuccess(false);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除intent_phrase
	 * 
	 * @return
	 */
	 @RequestMapping(value  = "doBatchDel",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doBatchDel(String ids){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "intent_phrase删除成功";
		try{
			for(String id:ids.split(",")){

				int i = Integer.parseInt(id);
				intentPhraseService.delete(i);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "intent_phrase删除失败";
			j.setSuccess(false);
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加intent_phrase
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value  = "doAdd",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doAdd(IntentPhraseEntity intentPhrase) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "intent_phrase添加成功";
		try{
			intentPhraseService.save(intentPhrase);
		}catch(Exception e){
			e.printStackTrace();
			message = "intent_phrase添加失败";
			j.setSuccess(false);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新intent_phrase
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value  = "doUpdate",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doUpdate(IntentPhraseEntity intentPhrase) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "intent_phrase更新成功";
		try {
			intentPhraseService.saveOrUpdate(intentPhrase);
		} catch (Exception e) {
			e.printStackTrace();
			message = "intent_phrase更新失败";
			j.setSuccess(false);
		}
		j.setMsg(message);
		return j;
	}
	


	
}
