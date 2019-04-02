package com.example.demo.service;
import com.example.demo.bean.mysql.EmailSellResponseBeggin;


import java.io.Serializable;

public interface EmailSellResponseBegginServiceI {
	
 	public void delete(EmailSellResponseBeggin entity) throws Exception;
 	
 	public Serializable save(EmailSellResponseBeggin entity) throws Exception;
 	
 	public void saveOrUpdate(EmailSellResponseBeggin entity) throws Exception;
 	
}
