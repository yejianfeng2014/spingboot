package com.example.demo.service;

import com.example.demo.bean.mysql.IntentEntity;

import java.util.List;

public interface IntentServiceI {


	/**
	 * 根据实体删除
	 * @param entity
	 * @throws Exception
	 */
	public void delete(IntentEntity entity) throws Exception;

	/**
	 * 根据id 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception;

	/**
	 * 增加一个
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public int save(IntentEntity entity) throws Exception;

	/**
	 * 更新
	 * @param entity
	 * @throws Exception
	 */

	public void saveOrUpdate(IntentEntity entity) throws Exception;

	/**
	 * 查询总数
	 * @return
	 */
	public long totalSum();

	/**
	 * 分页查询
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	List<IntentEntity> queryStudentsBySql(int currPage, int pageSize);




}
