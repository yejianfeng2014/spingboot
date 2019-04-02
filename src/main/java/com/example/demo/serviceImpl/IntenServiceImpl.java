package com.example.demo.serviceImpl;

import com.example.demo.service.IntenServiceI;
import org.springframework.stereotype.Service;

import java.io.InputStream;


@Service
public class IntenServiceImpl implements IntenServiceI {




    @Override
    public InputStream enText2Voice(String text) {
        return null;
    }

    @Override
    public Object cnText2Voice(String text) {
        return null;
    }

    @Override
    public Object getintenAll() {
        return null;
    }

    @Override
    public Object getintenpage() {
        return null;
    }

    @Override
    public void delintentionByID() {

    }
}
