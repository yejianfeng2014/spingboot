package com.example.demo.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.bean.mysql.Temail;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.TEmailServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Controller
 * @Description: t_email
 * @date 2019-04-03 17:50:18
 */
@Api(value = "TEmail", description = "邮件内容展示和标注", tags = "tEmailController")
@Controller
@RequestMapping("/tEmailController")
public class TEmailController {
    private static final Logger logger = LoggerFactory.getLogger(TEmailController.class);

    @Autowired
    private TEmailServiceI tEmailService;
    /**
     * t_email列表 页面跳转
     *
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(HttpServletRequest request) {
        return "webpage//tEmailList";
    }

    /**
     * easyui AJAX请求数据
     *
     * @param dataGrid
     */
    @RequestMapping(value = "datagrid",method = RequestMethod.GET)
    @ResponseBody
    public Object datagrid(DataGrid dataGrid) {

        AjaxJson j = new AjaxJson();
        try {
            int page = dataGrid.getPage();
            int rows = dataGrid.getRows();
            List<Temail> emailSellResponseBeggins = tEmailService.queryPageBySql(page, rows);
            long l1 = tEmailService.totalSum();
            Map<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("total", l1);
            stringObjectHashMap.put("rows", emailSellResponseBeggins);
            stringObjectHashMap.put("success", false);
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
     * 删除t_email
     *
     * @return
     */
    @RequestMapping(value = "doDel",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doDel(Temail tEmail) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "t_email删除成功";
        try {
            tEmailService.delete(tEmail);
        } catch (Exception e) {
            e.printStackTrace();
            message = "t_email删除失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除t_email
     *
     * @return
     */
    @RequestMapping(value = "doBatchDel",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "t_email删除成功";
        try {
            for (String id : ids.split(",")) {

                Temail temail = new Temail();
                temail.setId(Integer.parseInt(id));

                tEmailService.delete(temail);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "t_email删除失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加t_email
     *
     * @param
     * @return
     */
    @RequestMapping(value = "doAdd",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doAdd(Temail tEmail) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "t_email添加成功";
        try {
            tEmailService.save(tEmail);
        } catch (Exception e) {
            e.printStackTrace();
            message = "t_email添加失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新t_email
     *
     * @param
     * @return
     */
    @RequestMapping(value = "doUpdate",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doUpdate(Temail tEmail) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "t_email更新成功";
        try {
            tEmailService.saveOrUpdate(tEmail);
        } catch (Exception e) {
            e.printStackTrace();
            message = "t_email更新失败";
            j.setSuccess(false);
        }
        j.setMsg(message);
        return j;
    }

    @RequestMapping(value = "getOne2BJ",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson getOne2Biaoji(){

        String msg ="获取需要标记的内容成功";
        AjaxJson j = new AjaxJson();
        try {
            Temail one2Biaoji = tEmailService.getOne2Biaoji();
            j.setObj(one2Biaoji);
        } catch (Exception e) {
            e.printStackTrace();

            msg = "获取需要标记的内容失败";
            j.setSuccess(false);
        }

        j.setMsg(msg);
        return j;
    }

}
