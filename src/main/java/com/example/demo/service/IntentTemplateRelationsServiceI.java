package com.example.demo.service;
import com.example.demo.bean.mysql.IntentTemplateRelationsEntity;

import java.util.List;

public interface IntentTemplateRelationsServiceI {
	public void delete(IntentTemplateRelationsEntity entity) throws Exception;
	public void delete(int id) throws Exception;

	public int save(IntentTemplateRelationsEntity entity) throws Exception;

	public void saveOrUpdate(IntentTemplateRelationsEntity entity) throws Exception;


	public long totalSum();

	List<IntentTemplateRelationsEntity> queryStudentsBySql(int currPage, int pageSize);

}
