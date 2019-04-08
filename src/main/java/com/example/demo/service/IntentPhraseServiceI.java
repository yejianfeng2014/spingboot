package com.example.demo.service;
import com.example.demo.bean.mysql.EmailSellResponseEnd;
import com.example.demo.bean.mysql.IntentPhraseEntity;

import java.io.Serializable;
import java.util.List;

public interface IntentPhraseServiceI {

	public void delete(IntentPhraseEntity entity) throws Exception;
	public void delete(int id) throws Exception;

	public int save(IntentPhraseEntity entity) throws Exception;

	public void saveOrUpdate(IntentPhraseEntity entity) throws Exception;


	public long totalSum();

	List<IntentPhraseEntity> queryStudentsBySql(int currPage, int pageSize);

}
