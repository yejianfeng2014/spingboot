package com.example.demo.service;
import com.example.demo.bean.mysql.EmailSellResponseBeggin;


import java.io.Serializable;
import java.util.List;

public interface EmailSellResponseBegginServiceI {
	
 	public void delete(EmailSellResponseBeggin entity) throws Exception;
 	
 	public int save(EmailSellResponseBeggin entity) throws Exception;
 	
 	public void saveOrUpdate(EmailSellResponseBeggin entity) throws Exception;


 	public long totalSum();

	List<EmailSellResponseBeggin> queryStudentsBySql(int currPage, int pageSize);


	List<EmailSellResponseBeggin> queryStudentsAll();


}
