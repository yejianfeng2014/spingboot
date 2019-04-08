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
 * @Description: intent_template_relations
 * @author onlineGenerator
 * @date 2019-04-08 10:00:44
 * @version V1.0   
 *
 */
//@Entity
//@Table(name = "intent_template_relations", schema = "")
@SuppressWarnings("serial")
public class IntentTemplateRelationsEntity implements java.io.Serializable {
	/**id*/
	private Integer id;
	/**intentId*/
//	@Excel(name="intentId",width=15)
	private Integer intentId;
	/**templateId*/
//	@Excel(name="templateId",width=15)
	private Integer templateId;
	/**意图id的描述*/
//	@Excel(name="意图id的描述",width=15)
	private String intentIdDetail;
	/**模板的描述*/
//	@Excel(name="模板的描述",width=15)
	private String templateIdDetail;
	
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  intentId
	 */

//	@Column(name ="INTENT_ID",nullable=true,length=10)
	public Integer getIntentId(){
		return this.intentId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  intentId
	 */
	public void setIntentId(Integer intentId){
		this.intentId = intentId;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  templateId
	 */

//	@Column(name ="TEMPLATE_ID",nullable=true,length=10)
	public Integer getTemplateId(){
		return this.templateId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  templateId
	 */
	public void setTemplateId(Integer templateId){
		this.templateId = templateId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  意图id的描述
	 */

//	@Column(name ="INTENT_ID_DETAIL",nullable=true,length=255)
	public String getIntentIdDetail(){
		return this.intentIdDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  意图id的描述
	 */
	public void setIntentIdDetail(String intentIdDetail){
		this.intentIdDetail = intentIdDetail;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模板的描述
	 */

//	@Column(name ="TEMPLATE_ID_DETAIL",nullable=true,length=255)
	public String getTemplateIdDetail(){
		return this.templateIdDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板的描述
	 */
	public void setTemplateIdDetail(String templateIdDetail){
		this.templateIdDetail = templateIdDetail;
	}
	
}
