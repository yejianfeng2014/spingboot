package com.example.demo.serviceImpl;

import com.example.demo.service.Text2voiceServcie;
import com.example.demo.service.gTTS4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Created by yejianfeng on 2018/11/14.
 */

@Service
public class Text2voiceServiceImpl  implements Text2voiceServcie{

    @Override
    public InputStream enText2Voice(String text) {



        InputStream is = null;
        gTTS4j gtts = new gTTS4j();
        try {
            gtts.init(text, "en", true, false);
            is = gtts.exec();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (is != null)
//                try {
//                    is.close();
//                }catch (Exception e){
//                    e.printStackTrace();
//                }

        }


        return is;
    }

    @Override
    public Object cnText2Voice(String text) {

        System.out.println("cn2 voiece");
        return null;
    }
}
