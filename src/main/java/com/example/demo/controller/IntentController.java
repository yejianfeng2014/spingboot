package com.example.demo.controller;


import com.example.demo.bean.mysql.IntentEntity;
import com.example.demo.bean.mysql.IntentPhraseEntity;
import com.example.demo.bean.mysql.Temail;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.model.json.DataGrid;
import com.example.demo.service.IntentPhraseServiceI;
import com.example.demo.service.IntentServiceI;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "IntentController", description = "意图管理")
@RequestMapping(value = "intent")
public class IntentController {
    private static final Logger logger = LoggerFactory.getLogger(IntentController.class);


    @Autowired
    private IntentServiceI intentServiceI;

    /**
     * 意图管理跳转页面
     *
     * @return
     */

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        // TODO: 2019/4/8  增加这个的跳转页面

        return "webpage/com/jeecg/com/emailSellResponseBegginList";
    }


    /**
     * 增加意图
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/datagrid", method = RequestMethod.GET)
    @ResponseBody
    public Object datagrid(DataGrid dataGrid) {

        AjaxJson j = new AjaxJson();
        try {
            int page = dataGrid.getPage();
            int rows = dataGrid.getRows();
            List<IntentEntity> emailSellResponseBeggins = intentServiceI.queryStudentsBySql(page, rows);
            long l1 = intentServiceI.totalSum();
            Map<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("total", l1);
            stringObjectHashMap.put("rows", emailSellResponseBeggins);
            stringObjectHashMap.put("success", true);
            logger.info("datagrid");
            return stringObjectHashMap;
        } catch (Exception e) {
            j.setMsg("datagrid query success");
            e.printStackTrace();
        }
        return j;

    }


    /**
     * 增加意图
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/doAdd", method = RequestMethod.POST)
    public AjaxJson doAdd(IntentEntity intentEntity) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "intent_phrase添加成功";
        try {
            intentServiceI.save(intentEntity);
        } catch (Exception e) {
            e.printStackTrace();
            message = "intent_phrase添加失败";
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 删除意图
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/doDel", method = RequestMethod.POST)
    public AjaxJson doDel(IntentEntity intentEntity) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "intent_phrase删除成功";
        try {
            intentServiceI.delete(intentEntity);
        } catch (Exception e) {
            e.printStackTrace();
            message = "intent_phrase删除失败";
        }
        j.setMsg(message);
        return j;

    }


    /**
     * 批量删除intent_phrase
     *
     * @return
     */
    @RequestMapping(value = "doBatchDel", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doBatchDel(String ids) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "intent删除成功";
        try {
            for (String id : ids.split(",")) {

                int i = Integer.parseInt(id);
                intentServiceI.delete(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "intente删除失败";
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 更新intent
     *
     * @param
     * @return
     */
    @RequestMapping(value = "doUpdate", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doUpdate(IntentEntity intent) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "intent_phrase更新成功";
        try {
            intentServiceI.saveOrUpdate(intent);
        } catch (Exception e) {
            e.printStackTrace();
            message = "intent_phrase更新失败";
        }
        j.setMsg(message);
        return j;
    }


    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public String home(String text) {

//        String lanuage = LanguageDec.getLanuage(text);
        return " ";
    }


    /**
     * 标记
     *
     * @param text
     * @return
     */
    @RequestMapping(value = "/biaoji", method = RequestMethod.GET)
    public Temail toBiaoji(String text) {

//        Email email = intentDao.toBiaoji();

        return null;

    }


    /*

     */
/**
 * 增加意图短语
 *
 * @param
 * @return
 *//*

    @RequestMapping(value = "/doAddContent", method = RequestMethod.POST)
    public void doAddContent(int id, String biaoji) {

        Temail email = new Temail();

        email.setId(id);
        email.setBiaoji(biaoji);

//        intentDao.updateEmail(email);

    }

    */
/**
 *
 *//*



     */
/**
 * 删除意图短语
 *
 * @param
 * @return
 *//*

    @RequestMapping(value = "/doDelContent", method = RequestMethod.POST)
    public void doDelContent(int id, String biaoji) {

        Temail email = new Temail();

        email.setId(id);
        email.setBiaoji(biaoji);

//        intentDao.updateEmail(email);

    }


    */
/**
 * 修改意图短语
 *
 * @param
 * @return
 *//*

    @RequestMapping(value = "/doUpdateContent", method = RequestMethod.POST)
    public void doUpdateContent(int id, String biaoji) {

        Temail email = new Temail();

        email.setId(id);
        email.setBiaoji(biaoji);
//        intentDao.updateEmail(email);

    }



    */
/**
 * 查看意图短语
 *
 * @param
 * @return
 *//*

    @RequestMapping(value = "/datagridContent", method = RequestMethod.POST)
    public void datagridContent(int id, String biaoji) {

        Temail email = new Temail();

        email.setId(id);
        email.setBiaoji(biaoji);
//        intentDao.updateEmail(email);

    }
*/


}
