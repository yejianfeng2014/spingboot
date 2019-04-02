package com.example.demo.controller;


import com.example.demo.bean.mysql.Temail;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Intent", description = "意图标注")
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
}
