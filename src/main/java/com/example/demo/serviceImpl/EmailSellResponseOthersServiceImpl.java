package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.EmailSellResponseOthers;
import com.example.demo.dao.mysql.EmailSellResponseOthersMapper;
import com.example.demo.service.EmailSellResponseOthersServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;

@Service("emailSellResponseOthersService")
@Transactional
public class EmailSellResponseOthersServiceImpl implements EmailSellResponseOthersServiceI {

	@Autowired
	private EmailSellResponseOthersMapper mapper;
	
 	public void delete(EmailSellResponseOthers entity) throws Exception{
 		mapper.deleteById(entity.getId());

 	}
 	
 	public Serializable save(EmailSellResponseOthers entity) throws Exception{
 		mapper.insert(entity);
 		return null;
 	}
 	
 	public void saveOrUpdate(EmailSellResponseOthers entity) throws Exception{
 		mapper.update(entity);
// 		super.saveOrUpdate(entity);
 	}

	@Override
	public long totalSum() {
		long total = mapper.total();
		return total;
	}

	@Override
	public List<EmailSellResponseOthers> queryStudentsBySql(int currPage, int pageSize) {

		Map<String, Object> data = new HashMap<>();
		data.put("currIndex", (currPage-1)*pageSize);
		data.put("pageSize", pageSize);
		List<EmailSellResponseOthers> emailSellResponseEnds = mapper.queryPageBySql(data);
		return emailSellResponseEnds;

	}
}