package com.example.demo.service;

import com.example.demo.bean.mysql.EmailSellResponseMid;

import java.io.Serializable;

public interface EmailSellResponseMidServiceI {
	
 	public void delete(EmailSellResponseMid entity) throws Exception;
 	
 	public Serializable save(EmailSellResponseMid entity) throws Exception;
 	
 	public void saveOrUpdate(EmailSellResponseMid entity) throws Exception;
 	
}
