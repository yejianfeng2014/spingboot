package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.IntentPhraseEntity;
import com.example.demo.dao.mysql.IntentPhraseMapper;
import com.example.demo.service.IntentPhraseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("intentPhraseService")
@Transactional
public class IntentPhraseServiceImpl  implements IntentPhraseServiceI {


	@Autowired
	IntentPhraseMapper mapper;

	@Override
	public void delete(IntentPhraseEntity entity) throws Exception {

		mapper.deleteById(entity.getId());

	}

	@Override
	public int save(IntentPhraseEntity entity) throws Exception {

		mapper.insert(entity);
		return 0;
	}

	@Override
	public void saveOrUpdate(IntentPhraseEntity entity) throws Exception {

		mapper.update(entity);

	}

	@Override
	public void delete(int id) throws Exception {

		mapper.deleteById(id);

	}

	@Override
	public long totalSum() {

		long total = mapper.total();

		return total;
	}

	@Override
	public List<IntentPhraseEntity> queryBySql(int currPage, int pageSize) {

		Map<String, Object> data = new HashMap<>();
		data.put("currIndex", (currPage-1)*pageSize);
		data.put("pageSize", pageSize);
		List<IntentPhraseEntity> intentPhraseEntitys = mapper.queryPageBySql(data);
		return intentPhraseEntitys;


	}

	@Override
	public List<IntentPhraseEntity> queryByid(int phraseId) {
		List<IntentPhraseEntity> intentPhraseEntities = mapper.queryByPhraseId(phraseId);

		return intentPhraseEntities;
	}
}