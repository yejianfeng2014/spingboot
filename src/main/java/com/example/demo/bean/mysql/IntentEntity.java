package com.example.demo.bean.mysql;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.io.UnsupportedEncodingException;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;


/**   
 * @Title: Entity
 * @Description: intent
 * @author onlineGenerator
 * @date 2019-04-08 09:59:27
 * @version V1.0   
 *
 */

@SuppressWarnings("serial")
public class IntentEntity implements java.io.Serializable {
	/**id*/
	private Integer id;
	/**意图名称*/
	private String intentName;
	/**意图描述*/
//	@Excel(name="意图描述",width=15)
	private String intentDetail;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//
//	@Column(name ="ID",nullable=false,length=10)
	public Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  意图名称
	 */

//	@Column(name ="INTENT_NAME",nullable=true,length=255)
	public String getIntentName(){
		return this.intentName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  意图名称
	 */
	public void setIntentName(String intentName){
		this.intentName = intentName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  意图描述
	 */

//	@Column(name ="INTENT_DETAIL",nullable=true,length=255)
	public String getIntentDetail(){
		return this.intentDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  意图描述
	 */
	public void setIntentDetail(String intentDetail){
		this.intentDetail = intentDetail;
	}
	
}
