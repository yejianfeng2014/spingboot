package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.EmailSellResponseMid;
import com.example.demo.dao.mysql.EmailSellResponseMidMapper;
import com.example.demo.service.EmailSellResponseMidServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@Service("emailSellResponseMidService")
@Transactional
public class EmailSellResponseMidServiceImpl  implements EmailSellResponseMidServiceI {

	@Autowired
	private EmailSellResponseMidMapper emailSellResponseMidMapper;
	
 	public void delete(EmailSellResponseMid entity) throws Exception{

		emailSellResponseMidMapper.deleteById(entity.getId());
// 		super.delete(entity);
 	}
 	
 	public Serializable save(EmailSellResponseMid entity) throws Exception{

		emailSellResponseMidMapper.insert(entity);
// 		Serializable t = super.save(entity);
 		return null;
 	}
 	
 	public void saveOrUpdate(EmailSellResponseMid entity) throws Exception{

		emailSellResponseMidMapper.update(entity);
// 		super.saveOrUpdate(entity);
 	}

	@Override
	public long totalSum() {
		long total = emailSellResponseMidMapper.total();

		return total;
	}

	@Override
	public List<EmailSellResponseMid> queryStudentsBySql(int currPage, int pageSize) {
		Map<String, Object> data = new HashMap<>();
		data.put("currIndex", (currPage-1)*pageSize);
		data.put("pageSize", pageSize);
		List<EmailSellResponseMid> emailSellResponseEnds = emailSellResponseMidMapper.queryPageBySql(data);
		return emailSellResponseEnds;
	}
}