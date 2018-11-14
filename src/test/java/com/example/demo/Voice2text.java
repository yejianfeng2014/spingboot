package com.example.demo;

import com.example.demo.service.gTTS4j;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


/**
 *
 * 文字转语音做完
 */

public class Voice2text {

    @Test
    public void gTTSTest() throws IOException {

        InputStream is = null;
        String text = "how old are you ?";
        gTTS4j gtts = new gTTS4j();
        try {
            gtts.init(text, "en", true, false);
            is = gtts.exec();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) is.close();
        }
    }

}
