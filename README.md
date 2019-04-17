# spingboot
为聊天机器人的前提准备工作搭建的环境调用

中文句子朗读，英文句子朗读，都是调用google的api 实现

对话采用tensorflow 训练的聊天机器人

swagger api 页面
http://localhost:8888//AI_customer_service/swagger-ui.html#/


导入自定的jar 
进入jars 目录 执行以下命令

mvn install:install-file -Dfile=./javamitie.jar -DgroupId=orderplus.com.cn -DartifactId=javamitie - Dversion=1.0 -Dpackaging=jar



反向生成到层的文件  添加完插件后

mybatis-generator:generate –e 


修改批量删除的方法，因为采用循环一个一个删除，会出现中间中断删了一部分的情况


# 添加了项目路径后的访问路径如下：
http://localhost:8888/AI_customer_service/emailSellResponseBegginController/list
http://localhost:8888/AI_customer_service/emailSellResponseMidController/list
http://localhost:8888/AI_customer_service/emailSellResponseEndController/list
http://localhost:8888/AI_customer_service/emailSellResponseOthersController/list




#使用过程描述：
1,修改application.proproperties 的数据库访问路径
2,然后打包，mvn clean package -DskipTests，会在target 目录下生成 ***.war 文件
3, 运行，java -jar  ***.war 
4, 访问 http://localhost:8888/AI_customer_service/swagger-ui.html#


# 投诉自动回复流程 前端发送过来的数据，---> 内容根据句子进行分割----> 根据句子提取对应的意图 --->根据意图查找模板-----> 回复模板
涉及的表如下：bt_ai_intent 意图管理 0.1版本
            bt_ai_intent_phrase 意图短语管理表0.1版本
            bt_ai_intent_template_relations 意图模板关系表 0.1版本
            bt_ai_paypal_response_templates 投诉回复模板表 0.1版本
            bt_ai_raw_data_log 每次接受到的信息
            
            
            
            
paypal 处理

 1,根据tx 号 判断是否全部发货  获取第二步的信息
 2,根据orderNo siteID 查询 物流信息  获取第三步需要的信息
 3,根据 ExpressNo 查询物流状态 
 
 4,根据 ExpressNo 创建一个物流查询请求
 5,根据 ExpressNo  进行查询
 
 
  全部发货的状态下进行条件判断
  
    1，正常在途，小于7天物流在更新
    2，物流显示已经妥投，
    3，长期不更新 快递30天以上不更新，小包45-60天不更新
    4，物流显示未妥投已经退回
 
 
 
 
            
todos 

1,部分发货的返回结果，需要进一步分细节处理，tracking_number 对应已经发货和未发货，需要进一步处理。
2,       
            
            
            