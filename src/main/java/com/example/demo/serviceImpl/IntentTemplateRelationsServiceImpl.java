package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.EmailSellResponseEnd;
import com.example.demo.bean.mysql.IntentEntity;
import com.example.demo.bean.mysql.IntentTemplateRelationsEntity;
import com.example.demo.dao.mysql.IntentTemplateRelationMapper;
import com.example.demo.service.IntentTemplateRelationsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("intentTemplateRelationsService")
@Transactional
public class IntentTemplateRelationsServiceImpl  implements IntentTemplateRelationsServiceI {

	@Autowired
	IntentTemplateRelationMapper mapper;

	@Override
	public void delete(IntentTemplateRelationsEntity entity) throws Exception {

		mapper.deleteById(entity.getId());

	}

	@Override
	public void delete(int id) throws Exception {
		mapper.deleteById(id);

	}

	@Override
	public int save(IntentTemplateRelationsEntity entity) throws Exception {

		mapper.insert(entity);
		return 0;
	}

	@Override
	public void saveOrUpdate(IntentTemplateRelationsEntity entity) throws Exception {

		mapper.update(entity);

	}

	@Override
	public long totalSum() {

		long total = mapper.total();
		return total;
	}

	@Override
	public List<IntentTemplateRelationsEntity> queryStudentsBySql(int currPage, int pageSize) {
		Map<String, Object> data = new HashMap<>();
		data.put("currIndex", (currPage-1)*pageSize);
		data.put("pageSize", pageSize);
		List<IntentTemplateRelationsEntity> intentTemplateRelationsEntitys = mapper.queryPageBySql(data);
		return intentTemplateRelationsEntitys;
	}



}