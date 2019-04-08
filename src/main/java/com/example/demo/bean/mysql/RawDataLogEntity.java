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
 * @Description: 接收到的数据
 * @author onlineGenerator
 * @date 2019-04-08 14:15:32
 * @version V1.0   
 *
 */
//@Entity
//@Table(name = "raw_data_log", schema = "")
@SuppressWarnings("serial")
public class RawDataLogEntity implements java.io.Serializable {
	/**主键*/
	private Integer id;
	/**收到的内容*/
//	@Excel(name="收到的内容",width=15)
	private String rawText;
	/**数据来源*/
//	@Excel(name="数据来源",width=15)
	private String sourceType;
	/**插入时间*/
//	@Excel(name="插入时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private Date insertDate;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//
//	@Column(name ="ID",nullable=false,length=20)
	public Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收到的内容
	 */

//	@Column(name ="RAW_TEXT",nullable=true,length=2000)
	public String getRawText(){
		return this.rawText;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收到的内容
	 */
	public void setRawText(String rawText){
		this.rawText = rawText;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数据来源
	 */

//	@Column(name ="SOURCE_TYPE",nullable=true,length=32)
	public String getSourceType(){
		return this.sourceType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据来源
	 */
	public void setSourceType(String sourceType){
		this.sourceType = sourceType;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  插入时间
	 */

//	@Column(name ="INSERT_DATE",nullable=true,length=32)
	public Date getInsertDate(){
		return this.insertDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  插入时间
	 */
	public void setInsertDate(Date insertDate){
		this.insertDate = insertDate;
	}
	
}
