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
 * @Description: intent_phrase
 * @author onlineGenerator
 * @date 2019-04-08 09:59:46
 * @version V1.0   
 *
 */
//@Entity
//@Table(name = "intent_phrase", schema = "")
@SuppressWarnings("serial")
public class IntentPhraseEntity implements java.io.Serializable {
	/**id*/
	private Integer id;
	/**意图id,来自intent表的主键*/
//	@Excel(name="意图id,来自intent表的主键",width=15)
	private Integer intentId;
	/**意图语句*/
//	@Excel(name="意图语句",width=15)
	private String intentPhrase;
	/**短语描述*/
//	@Excel(name="短语描述",width=15)
	private String intentDetail;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)

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
	 *@return: java.lang.String  意图id,来自intent表的主键
	 */

//	@Column(name ="INTENT_ID",nullable=true,length=255)
	public int getIntentId(){
		return this.intentId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  意图id,来自intent表的主键
	 */
	public void setIntentId(int intentId){
		this.intentId = intentId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  意图语句
	 */

//	@Column(name ="INTENT_PHRASE",nullable=true,length=255)
	public String getIntentPhrase(){
		return this.intentPhrase;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  意图语句
	 */
	public void setIntentPhrase(String intentPhrase){
		this.intentPhrase = intentPhrase;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  短语描述
	 */

//	@Column(name ="INTENT_DETAIL",nullable=true,length=255)
	public String getIntentDetail(){
		return this.intentDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  短语描述
	 */
	public void setIntentDetail(String intentDetail){
		this.intentDetail = intentDetail;
	}
	
}
