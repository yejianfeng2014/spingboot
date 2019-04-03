package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.EmailSellResponseBeggin;

import com.example.demo.dao.mysql.EmailSellResponseBegginMapper;
import com.example.demo.service.EmailSellResponseBegginServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@Service("emailSellResponseBegginService")
@Transactional
public class EmailSellResponseBegginServiceImpl  implements EmailSellResponseBegginServiceI {

	@Autowired
	private EmailSellResponseBegginMapper mapper;
	
 	public void delete(EmailSellResponseBeggin entity) throws Exception{

 		mapper.deleteById(entity.getId());

 	}
 	
 	public int save(EmailSellResponseBeggin entity) throws Exception{

		int insert = mapper.insert(entity);
 		return insert;
 	}
 	
 	public void saveOrUpdate(EmailSellResponseBeggin entity) throws Exception{

		int update = mapper.update(entity);
 	}


	@Override
	public long totalSum() {

		long total = mapper.total();

		return  total;
	}

	@Override
	public List<EmailSellResponseBeggin> queryStudentsBySql(int currPage, int pageSize) {
		Map<String, Object> data = new HashMap<>();
		data.put("currIndex", (currPage-1)*pageSize);
		data.put("pageSize", pageSize);
		return mapper.queryPageBySql(data);
	}


	@Override
	public List<EmailSellResponseBeggin> queryStudentsAll() {
		List<EmailSellResponseBeggin> all = mapper.getALL();

		return  all;
	}
}