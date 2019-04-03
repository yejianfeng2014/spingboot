package com.example.demo.service;

import com.example.demo.bean.mysql.EmailSellResponseOthers;

import java.io.Serializable;

public interface EmailSellResponseOthersServiceI {
	
 	public void delete(EmailSellResponseOthers entity) throws Exception;
 	
 	public Serializable save(EmailSellResponseOthers entity) throws Exception;
 	
 	public void saveOrUpdate(EmailSellResponseOthers entity) throws Exception;
 	
}
