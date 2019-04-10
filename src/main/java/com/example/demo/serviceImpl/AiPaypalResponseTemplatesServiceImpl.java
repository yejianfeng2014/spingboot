package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.AiPaypalResponseTemplatesEntity;
import com.example.demo.dao.mysql.AiPaypalResponseTemplatesMapper;
import com.example.demo.service.AiPaypalResponseTemplatesServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("aiPaypalResponseTemplatesService")
@Transactional
public class AiPaypalResponseTemplatesServiceImpl implements AiPaypalResponseTemplatesServiceI {


	@Autowired
	AiPaypalResponseTemplatesMapper mapper;

	public void delete(AiPaypalResponseTemplatesEntity entity) throws Exception{

		mapper.deleteById(entity.getId());

	}

	@Override
	public void delete(Integer id) throws Exception {
		mapper.deleteById(id);
	}

	public int save(AiPaypalResponseTemplatesEntity entity) throws Exception{

		int insert = mapper.insert(entity);
		return insert;
	}

	public void saveOrUpdate(AiPaypalResponseTemplatesEntity entity) throws Exception{

		int update = mapper.update(entity);
	}


	@Override
	public long totalSum() {

		long total = mapper.total();

		return  total;
	}

	@Override
	public List<AiPaypalResponseTemplatesEntity> queryStudentsBySql(int currPage, int pageSize) {
		Map<String, Object> data = new HashMap<>();
		data.put("currIndex", (currPage-1)*pageSize);
		data.put("pageSize", pageSize);
		return mapper.queryPageBySql(data);
	}


//	@Override
//	public List<AiPaypalResponseTemplatesEntity> queryStudentsAll() {
//		List<EmailSellResponseBeggin> all = mapper.getALL();
//
//		return  all;
//	}
 	
}