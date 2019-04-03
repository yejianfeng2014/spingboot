package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.EmailSellResponseEnd;
import com.example.demo.service.EmailSellResponseEndServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Service("emailSellResponseEndService")
@Transactional
public class EmailSellResponseEndServiceImpl  implements EmailSellResponseEndServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(EmailSellResponseEnd entity) throws Exception{
// 		super.delete(entity);
 	}
 	
 	public Serializable save(EmailSellResponseEnd entity) throws Exception{
// 		Serializable t = super.save(entity);
 		return null;
 	}
 	
 	public void saveOrUpdate(EmailSellResponseEnd entity) throws Exception{
// 		super.saveOrUpdate(entity);
 	}
 	
}