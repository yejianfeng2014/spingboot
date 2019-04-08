package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.bean.mysql.RawDataLogEntity;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.RawDataLogServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Controller
 * @Description: 接收到的数据
 * @date 2019-04-08 14:15:32
 */
@Controller
@RequestMapping("/rawDataLogController")
public class RawDataLogController {
    private static final Logger logger = LoggerFactory.getLogger(RawDataLogController.class);

    @Autowired
    private RawDataLogServiceI rawDataLogService;


    /**
     * 接收到的数据列表 页面跳转
     *
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/jeecg/com/rawDataLogList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param dataGrid
     * @param
     */
    @RequestMapping(value = "datagrid",method = RequestMethod.GET)
    @ResponseBody
    public Object datagrid(DataGrid dataGrid) {
        AjaxJson j = new AjaxJson();
        try {
            int page = dataGrid.getPage();
            int rows = dataGrid.getRows();
            List<RawDataLogEntity> emailSellResponseBeggins = rawDataLogService.queryStudentsBySql(page, rows);
            long l1 = rawDataLogService.totalSum();
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
     * 删除接收到的数据
     *
     * @return
     */
    @RequestMapping(value = "doDel",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doDel(RawDataLogEntity rawDataLog) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "接收到的数据删除成功";
        try {
            rawDataLogService.delete(rawDataLog);

        } catch (Exception e) {
            e.printStackTrace();
            message = "接收到的数据删除失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除接收到的数据
     *
     * @return
     */
    @RequestMapping(value = "doBatchDel",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "接收到的数据删除成功";
        try {
            for (String id : ids.split(",")) {

                Integer i = Integer.parseInt(id);

                rawDataLogService.delete(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "接收到的数据删除失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加接收到的数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "doAdd",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doAdd(RawDataLogEntity rawDataLog) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "接收到的数据添加成功";
        try {
            rawDataLogService.save(rawDataLog);
        } catch (Exception e) {
            e.printStackTrace();
            message = "接收到的数据添加失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新接收到的数据
     *
     * @param
     * @return
     */
    @RequestMapping(value = "doUpdate",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doUpdate(RawDataLogEntity rawDataLog) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "接收到的数据更新成功";
        try {
            rawDataLogService.save(rawDataLog);
        } catch (Exception e) {
            e.printStackTrace();
            message = "接收到的数据更新失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }


}
