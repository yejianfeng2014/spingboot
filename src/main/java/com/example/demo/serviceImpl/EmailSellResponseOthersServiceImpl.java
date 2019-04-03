package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.EmailSellResponseOthers;
import com.example.demo.service.EmailSellResponseOthersServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Service("emailSellResponseOthersService")
@Transactional
public class EmailSellResponseOthersServiceImpl implements EmailSellResponseOthersServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(EmailSellResponseOthers entity) throws Exception{
// 		super.delete(entity);

 	}
 	
 	public Serializable save(EmailSellResponseOthers entity) throws Exception{
// 		Serializable t = super.save(entity);
 		return null;
 	}
 	
 	public void saveOrUpdate(EmailSellResponseOthers entity) throws Exception{
// 		super.saveOrUpdate(entity);
 	}
 	
}