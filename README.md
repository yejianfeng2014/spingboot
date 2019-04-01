# spingboot
为聊天机器人的前提准备工作搭建的环境调用

中文句子朗读，英文句子朗读，都是调用google的api 实现

对话采用tensorflow 训练的聊天机器人

swagger api 页面
http://localhost:8888/swagger-ui.html#/


导入自定的jar 
进入jars 目录 执行以下命令

mvn install:install-file -Dfile=./javamitie.jar -DgroupId=orderplus.com.cn -DartifactId=javamitie - Dversion=1.0 -Dpackaging=jar
