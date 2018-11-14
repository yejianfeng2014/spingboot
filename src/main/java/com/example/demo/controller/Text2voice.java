package com.example.demo.controller;

import com.example.demo.service.Text2voiceServcie;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yejianfeng on 2018/11/14.
 */

@Controller
@Api(tags = "text2voiceController",description = "text2voiceController ")
@RequestMapping(value = "text2voice")
public class Text2voice {
    @Autowired
    private Text2voiceServcie text2voiceServcie;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    @ResponseBody
    public  String text2voice_index(){


        return  "text2voice";
    }

    /**
     *  输入 英文句子
     * @return 返回语音
     */
    @RequestMapping(value = "/text",method = RequestMethod.GET)
    public  void en2voice_index(String data, HttpServletRequest request, HttpServletResponse response){

        System.out.println(data);

        InputStream inputStream = null;

        try{
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            //2.设置文件头：最后一个参数是设置下载文件名
            response.setHeader("Content-Disposition", "attachment;fileName=zms.mp3");

            //通过文件路径获得File对象(假如此路径中有一个 zms.jpg 文件)
//            File file = new File("E:/template/zms.jpg");



            inputStream = text2voiceServcie.enText2Voice(data);
            System.out.println("文件size:"+String.valueOf(inputStream.available()/1000)+"k");

            //3.通过response获取ServletOutputStream对象(out)
            int b = 0;
            byte[] buffer = new byte[512];
            while (b != -1){
                b = inputStream.read(buffer);
                if(b != -1){
                    response.getOutputStream().write(buffer,0,b);//4.写到输出流(out)中
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                response.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 输入中文句子
     * @param text
     * @return
     */
    @RequestMapping(value = "/text_cn",method = RequestMethod.GET)
    @ResponseBody
    public  String cn2voice_index(String text){

        Object o = text2voiceServcie.cnText2Voice(text);

        return  "text2voice";
    }




}
