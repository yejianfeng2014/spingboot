package com.example.demo.service;
import com.example.demo.bean.mysql.IntentPhraseEntity;

import java.util.List;

public interface IntentPhraseServiceI {

	public void delete(IntentPhraseEntity entity) throws Exception;
	public void delete(int id) throws Exception;

	public int save(IntentPhraseEntity entity) throws Exception;

	public void saveOrUpdate(IntentPhraseEntity entity) throws Exception;


	public long totalSum();

	List<IntentPhraseEntity> queryBySql(int currPage, int pageSize);


	/**
	 * 根据意图id 查询改意图的多有短语
	 * @param phraseId
	 * @return
	 */
	List<IntentPhraseEntity> queryByid(int phraseId);


	List<IntentPhraseEntity> queryByPhrase(String text);


	/**
	 * 根据短语返回查询的数量
	 * @param text
	 * @return
	 */
	int queryByPhrase2Int(String text);





}
