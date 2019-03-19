package com.example.demo.daoImple;

import com.example.demo.dao.UserDao;
import com.example.demo.entry.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public class UserDaoImple implements UserDao {


   @Resource
   private JdbcTemplate jdbcTemplate;

   @Override
   public User getUser(String id) {




      String query_sql = "select * from user where id = ?";
      RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
      User user= jdbcTemplate.queryForObject(query_sql, rowMapper,id);
      System.out.println(user);



//      User user = jdbcTemplate.queryForObject(query_sql, User.class);


      return  user;


   }
}
