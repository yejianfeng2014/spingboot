package com.example.demo.serviceImpl;

import com.example.demo.bean.mysql.Temail;
import com.example.demo.dao.mysql.TemailMapper;
import com.example.demo.service.TEmailServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yejianfeng on 2018/11/14.
 *
 *
 * 标注过程
 * 标注数据的增，删，改，查
 *
 */

@Service
public class EmailOperatServiceImpl implements TEmailServiceI {

    @Override
    public Temail getOne2Biaoji() {

        Temail temail = temailMapper.selectOnetoBiaoji();
        return temail;
    }

    @Autowired
    TemailMapper temailMapper;


    @Override
    public void delete(Temail entity) throws Exception {

        temailMapper.deleteByPrimaryKey(entity.getId());

    }

    @Override
    public int save(Temail entity) throws Exception {

        int insert = temailMapper.insert(entity);
        return insert;
    }

    @Override
    public void saveOrUpdate(Temail entity) throws Exception {

        int i = temailMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public long totalSum() {
        long total = temailMapper.total();
        return total;
    }

    @Override
    public List<Temail> queryPageBySql(int currPage, int pageSize) {

        Map<String, Object> data = new HashMap<>();
        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        return temailMapper.queryPageBySql(data);

    }

    @Override
    public List<Temail> queryStudentsAll() {
        List<Temail> temails = temailMapper.selectAll();

        return temails;
    }
}
