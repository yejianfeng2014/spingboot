package com.example.demo.daoImple;

import com.example.demo.dao.IntentDao;
import com.example.demo.entry.Email;
import com.example.demo.entry.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository

public class IntentDaoImple implements IntentDao {


    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Email toBiaoji() {


        String query_sql = "select * from t_email where  biaoji is null  limit 1";
        RowMapper<Email> rowMapper=new BeanPropertyRowMapper<Email>(Email.class);
        Email email= jdbcTemplate.queryForObject(query_sql, rowMapper);
        System.out.println(email);
        return email;
    }


    @Override
    public void updateEmail(Email email) {

        jdbcTemplate.update("UPDATE t_email SET biaoji = ? WHERE id = ?", new Object[] {email.getBiaoji(), email.getId()});


    }
}
