package com.example.demo.serviceImpl;

import com.example.demo.bean.mysql.RawDataLogEntity;
import com.example.demo.dao.mysql.RawDataLogMapper;
import com.example.demo.service.RawDataLogServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.io.Serializable;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;


@Service("rawDataLogService")
@Transactional
public class RawDataLogServiceImpl  implements RawDataLogServiceI {

	@Autowired
	private RawDataLogMapper mapper;


	@Override
	public Serializable save(RawDataLogEntity entity) throws Exception {

		mapper.insert(entity);
		return null;
	}

	@Override
	public void Update(RawDataLogEntity entity) throws Exception {

		mapper.update(entity);

	}

	@Override
	public void delete(RawDataLogEntity entity) throws Exception {

		mapper.deleteById(entity.getId().longValue());

	}

	@Override
	public void delete(Integer id) throws Exception {

		mapper.deleteById(id.longValue());

	}

	@Override
	public long totalSum() {

		long total = mapper.total();
		return total;
	}

	@Override
	public List<RawDataLogEntity> queryStudentsBySql(int currPage, int pageSize) {
		Map<String, Object> data = new HashMap<>();
		data.put("currIndex", (currPage-1)*pageSize);
		data.put("pageSize", pageSize);
		List<RawDataLogEntity> rawDataLogEntitys = mapper.queryPageBySql(data);
		return rawDataLogEntitys;
	}
}