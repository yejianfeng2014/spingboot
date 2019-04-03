package com.example.demo.service;

import com.example.demo.bean.mysql.EmailSellResponseEnd;

import java.io.Serializable;
import java.util.List;

public interface EmailSellResponseEndServiceI {
	
 	public void delete(EmailSellResponseEnd entity) throws Exception;
 	
 	public int save(EmailSellResponseEnd entity) throws Exception;
 	
 	public void saveOrUpdate(EmailSellResponseEnd entity) throws Exception;


	public long totalSum();

	List<EmailSellResponseEnd> queryStudentsBySql(int currPage, int pageSize);



}
