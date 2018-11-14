package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Created by yejianfeng on 2018/11/14.
 */

public interface Text2voiceServcie {

    /**
     *  英文转换接口
     * @param text
     * @return
     */
    public InputStream enText2Voice(String text);

    /**
     *  中文转换接口
     * @param text
     * @return
     */
    public Object cnText2Voice(String text);

}
