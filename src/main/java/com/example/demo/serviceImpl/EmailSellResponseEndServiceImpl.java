package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.EmailSellResponseEnd;
import com.example.demo.dao.mysql.EmailSellResponseEndMapper;
import com.example.demo.service.EmailSellResponseEndServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@Service("emailSellResponseEndService")
@Transactional
public class EmailSellResponseEndServiceImpl  implements EmailSellResponseEndServiceI {

	@Autowired
	private EmailSellResponseEndMapper mapper;
	
 	public void delete(EmailSellResponseEnd entity) throws Exception{

 		mapper.deleteById(entity.getId());

// 		super.delete(entity);
 	}
 	
 	public int save(EmailSellResponseEnd entity) throws Exception{

		int insert = mapper.insert(entity);
// 		Serializable t = super.save(entity);
 		return insert;
 	}
 	
 	public void saveOrUpdate(EmailSellResponseEnd entity) throws Exception{

 		mapper.update(entity);
// 		super.saveOrUpdate(entity);
 	}

	@Override
	public long totalSum() {

		long total = mapper.total();
		return total;
	}

	@Override
	public List<EmailSellResponseEnd> queryStudentsBySql(int currPage, int pageSize) {

		Map<String, Object> data = new HashMap<>();
		data.put("currIndex", (currPage-1)*pageSize);
		data.put("pageSize", pageSize);

		List<EmailSellResponseEnd> emailSellResponseEnds = mapper.queryPageBySql(data);

		return emailSellResponseEnds;
	}
}