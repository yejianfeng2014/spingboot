package com.example.demo.service;

import com.example.demo.bean.mysql.EmailSellResponseEnd;

import java.io.Serializable;

public interface EmailSellResponseEndServiceI {
	
 	public void delete(EmailSellResponseEnd entity) throws Exception;
 	
 	public Serializable save(EmailSellResponseEnd entity) throws Exception;
 	
 	public void saveOrUpdate(EmailSellResponseEnd entity) throws Exception;
 	
}
