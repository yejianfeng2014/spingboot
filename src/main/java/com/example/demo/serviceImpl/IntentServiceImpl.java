package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.IntentEntity;
import com.example.demo.bean.mysql.IntentPhraseEntity;
import com.example.demo.dao.mysql.IntentMapper;
import com.example.demo.service.IntentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("intentService")
@Transactional
public class IntentServiceImpl  implements IntentServiceI {


	@Autowired
	IntentMapper mapper;

	@Override
	public void delete(IntentEntity entity) throws Exception {

		mapper.deleteById(entity.getId());

	}

	@Override
	public void delete(int id) throws Exception {

		mapper.deleteById(id);

	}

	@Override
	public int save(IntentEntity entity) throws Exception {

		mapper.insert(entity);
		return 0;
	}

	@Override
	public void saveOrUpdate(IntentEntity entity) throws Exception {

		mapper.update(entity);

	}

	@Override
	public long totalSum() {

		long total = mapper.total();
		return total;
	}

	@Override
	public List<IntentEntity> queryStudentsBySql(int currPage, int pageSize) {
		Map<String, Object> data = new HashMap<>();
		data.put("currIndex", (currPage-1)*pageSize);
		data.put("pageSize", pageSize);
		List<IntentEntity> intentEntitys = mapper.queryPageBySql(data);
		return intentEntitys;

	}
}