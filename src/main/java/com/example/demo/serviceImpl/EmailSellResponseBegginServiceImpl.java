package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.EmailSellResponseBeggin;

import com.example.demo.service.EmailSellResponseBegginServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Service("emailSellResponseBegginService")
@Transactional
public class EmailSellResponseBegginServiceImpl  implements EmailSellResponseBegginServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(EmailSellResponseBeggin entity) throws Exception{

// 		return null;

 	}
 	
 	public Serializable save(EmailSellResponseBeggin entity) throws Exception{
// 		Serializable t = super.save(entity);
 		return null;
 	}
 	
 	public void saveOrUpdate(EmailSellResponseBeggin entity) throws Exception{
// 		super.saveOrUpdate(entity);
 	}
 	
}