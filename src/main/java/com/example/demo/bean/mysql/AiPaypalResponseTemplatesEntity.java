package com.example.demo.bean.mysql;

import java.lang.String;
import java.lang.Integer;

/**   
 * @Title: Entity
 * @Description: ai_paypal_response_templates
 * @author onlineGenerator
 * @date 2019-04-10 15:08:35
 * @version V1.0   
 *
 */
//@Entity
//@Table(name = "ai_paypal_response_templates", schema = "")
@SuppressWarnings("serial")
public class AiPaypalResponseTemplatesEntity implements java.io.Serializable {
	/**id*/
	private Integer id;
	/**templateId*/
//	@Excel(name="templateId",width=15)
	private String templateId;
	/**responseTime*/
//	@Excel(name="responseTime",width=15)
	private String responseTime;
	/**contentType*/
//	@Excel(name="contentType",width=15)
	private String contentType;
	/**contentCn*/
//	@Excel(name="contentCn",width=15)
	private String contentCn;
	/**response*/
//	@Excel(name="response",width=15)
	private String contentResponse;
	/**cn*/
//	@Excel(name="cn",width=15)
	private String contentResponseCn;
	/**params*/
//	@Excel(name="params",width=15)
	private String responseParams;




	private  String intentName;
	private  String intentDetail;
	private  String intentPhrase;



	private String orderStatusName;

	private String responseParamsEn;

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public String getResponseParamsEn() {
		return responseParamsEn;
	}

	public void setResponseParamsEn(String responseParamsEn) {
		this.responseParamsEn = responseParamsEn;
	}

	public String getIntentName() {
		return intentName;
	}

	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}

	public String getIntentDetail() {
		return intentDetail;
	}

	public void setIntentDetail(String intentDetail) {
		this.intentDetail = intentDetail;
	}

	public String getIntentPhrase() {
		return intentPhrase;
	}

	public void setIntentPhrase(String intentPhrase) {
		this.intentPhrase = intentPhrase;
	}

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
	 *@return: java.lang.String  templateId
	 */

//	@Column(name ="TEMPLATE_ID",nullable=true,length=255)
	public String getTemplateId(){
		return this.templateId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  templateId
	 */
	public void setTemplateId(String templateId){
		this.templateId = templateId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  responseTime
	 */

//	@Column(name ="RESPONSE_TIME",nullable=true,length=6555)
	public String getResponseTime(){
		return this.responseTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  responseTime
	 */
	public void setResponseTime(String responseTime){
		this.responseTime = responseTime;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  contentType
	 */

//	@Column(name ="CONTENT_TYPE",nullable=true,length=6553)
	public String getContentType(){
		return this.contentType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  contentType
	 */
	public void setContentType(String contentType){
		this.contentType = contentType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  contentCn
	 */

//	@Column(name ="CONTENT_CN",nullable=true,length=6553)
	public String getContentCn(){
		return this.contentCn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  contentCn
	 */
	public void setContentCn(String contentCn){
		this.contentCn = contentCn;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  response
	 */

//	@Column(name ="CONTENT_RESPONSE",nullable=true,length=6553)
	public String getContentResponse(){
		return this.contentResponse;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  response
	 */
	public void setContentResponse(String contentResponse){
		this.contentResponse = contentResponse;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cn
	 */

//	@Column(name ="CONTENT_RESPONSE_CN",nullable=true,length=6553)
	public String getContentResponseCn(){
		return this.contentResponseCn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cn
	 */
	public void setContentResponseCn(String contentResponseCn){
		this.contentResponseCn = contentResponseCn;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  params
	 */

//	@Column(name ="RESPONSE_PARAMS",nullable=true,length=255)
	public String getResponseParams(){
		return this.responseParams;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  params
	 */
	public void setResponseParams(String responseParams){
		this.responseParams = responseParams;
	}
	
}
