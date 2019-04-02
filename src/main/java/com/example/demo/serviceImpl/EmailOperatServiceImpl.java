package com.example.demo.serviceImpl;

import com.example.demo.bean.mysql.Temail;
import com.example.demo.dao.mysql.TemailMapper;
import com.example.demo.service.EmailOperatServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yejianfeng on 2018/11/14.
 *
 *
 * 标注过程
 * 标注数据的增，删，改，查
 *
 */

@Service
public class EmailOperatServiceImpl implements EmailOperatServiceI {


    @Autowired
    TemailMapper temailMapper;

    @Override
    public Temail getOneEmail(String text) {


        Temail temail = temailMapper.selectByPrimaryKey(Integer.parseInt(text));


        return temail;

    }

    @Override
    public void updataEmail(Temail temail) {

        int i = temailMapper.updateByPrimaryKeySelective(temail);

    }

    @Override
    public void insert(Temail temail) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Temail> getALL() {

        List<Temail> temails = temailMapper.selectAll();

        return temails;
    }

    @Override
    public Temail getOne2Biaoji() {
        Temail temail = temailMapper.selectOnetoBiaoji();
        return temail;
    }


}
