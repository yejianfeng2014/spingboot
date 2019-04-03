package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.EmailSellResponseMid;
import com.example.demo.service.EmailSellResponseMidServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Service("emailSellResponseMidService")
@Transactional
public class EmailSellResponseMidServiceImpl  implements EmailSellResponseMidServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(EmailSellResponseMid entity) throws Exception{
// 		super.delete(entity);
 	}
 	
 	public Serializable save(EmailSellResponseMid entity) throws Exception{
// 		Serializable t = super.save(entity);
 		return null;
 	}
 	
 	public void saveOrUpdate(EmailSellResponseMid entity) throws Exception{
// 		super.saveOrUpdate(entity);
 	}
 	
}