package com.example.demo.service;

import java.io.InputStream;
import java.io.Serializable;

public interface IntentServiceI {
	/**
	 * 意图标注
	 * @param text
	 * @return
	 */
	public InputStream enText2Voice(String text);

	/**
	 *  意图查询
	 * @param text
	 * @return
	 */
	public Object cnText2Voice(String text);



	/**
	 *  意图查询所有
	 * @param
	 * @return
	 */
	public Object getintenAll();

	/**
	 *  意图分页查询
	 * @param
	 * @return
	 */
	public Object getintenpage();

	/**
	 * 删除意图
	 * 根据意图id 删除意图
	 *
	 */

	public  void  delintentionByID();

}
