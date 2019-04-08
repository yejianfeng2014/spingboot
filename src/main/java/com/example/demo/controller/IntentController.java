package com.example.demo.controller;


import com.example.demo.bean.mysql.Temail;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "IntentController", description = "意图管理")
@RequestMapping(value = "intent")
public class IntentController {


//    @Autowired
//    private IntentDao intentDao;


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


    /**
     * 标记
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void updateBiaoji(int id, String biaoji) {

        Temail email = new Temail();

            email.setId(id);
            email.setBiaoji(biaoji);

//        intentDao.updateEmail(email);

    }

    /**
     *  意图管理跳转页面
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
    @RequestMapping(value = "/doAdd", method = RequestMethod.POST)
    public void doAdd(int id, String biaoji) {

        Temail email = new Temail();

        email.setId(id);
        email.setBiaoji(biaoji);

//        intentDao.updateEmail(email);

    }



    /**
     * 删除意图
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/doDel", method = RequestMethod.POST)
    public void doDel(int id, String biaoji) {

        Temail email = new Temail();

        email.setId(id);
        email.setBiaoji(biaoji);

//        intentDao.updateEmail(email);

    }




    /**
     * 修改意图
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
    public void doUpdate(int id, String biaoji) {

        Temail email = new Temail();

        email.setId(id);
        email.setBiaoji(biaoji);

//        intentDao.updateEmail(email);

    }



    /**
     * 增加意图
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/datagrid", method = RequestMethod.GET)
    public void datagrid(int id, String biaoji) {

        Temail email = new Temail();

        email.setId(id);
        email.setBiaoji(biaoji);

//        intentDao.updateEmail(email);

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
