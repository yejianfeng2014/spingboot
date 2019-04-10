package com.example.demo.service;
import com.example.demo.bean.mysql.AiPaypalResponseTemplatesEntity;

import java.util.List;

public interface AiPaypalResponseTemplatesServiceI {

	public void delete(AiPaypalResponseTemplatesEntity entity) throws Exception;


    public void delete(Integer id) throws Exception;

	public int save(AiPaypalResponseTemplatesEntity entity) throws Exception;

	public void saveOrUpdate(AiPaypalResponseTemplatesEntity entity) throws Exception;


	public long totalSum();

	List<AiPaypalResponseTemplatesEntity> queryStudentsBySql(int currPage, int pageSize);


//	List<AiPaypalResponseTemplatesEntity> queryStudentsAll();


}
