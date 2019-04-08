package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.EmailSellResponseEnd;
import com.example.demo.bean.mysql.IntentTemplateRelationsEntity;
import com.example.demo.service.IntentTemplateRelationsServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("intentTemplateRelationsService")
@Transactional
public class IntentTemplateRelationsServiceImpl  implements IntentTemplateRelationsServiceI {

	@Override
	public void delete(IntentTemplateRelationsEntity entity) throws Exception {

	}

	@Override
	public void delete(int id) throws Exception {

	}

	@Override
	public int save(IntentTemplateRelationsEntity entity) throws Exception {
		return 0;
	}

	@Override
	public void saveOrUpdate(IntentTemplateRelationsEntity entity) throws Exception {

	}

	@Override
	public long totalSum() {
		return 0;
	}

	@Override
	public List<IntentTemplateRelationsEntity> queryStudentsBySql(int currPage, int pageSize) {
		return null;
	}



}