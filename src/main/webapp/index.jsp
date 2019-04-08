
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="webRoot" value="<%=basePath%>" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <script type="text/javascript" src="resources/jquery-3.3.1.js" charset="utf-8"></script>

</head>
<body>

<href></href>
<h1 align="center">这些事可以访问的链接地址
    <a href="${webRoot}/swagger-ui.html#/">swagger</a>
</h1>


<a href="${webRoot}/emailSellResponseBegginController/list">邮件回复的售前部分</a>
<br>
<a href="${webRoot}/emailSellResponseMidController/list">邮件回复的售中部分</a>
<br>
<a href="${webRoot}/emailSellResponseEndController/list">邮件回复售后</a>
<br>
<a href="${webRoot}/emailSellResponseOthersController/list">邮件回复的其他内容</a>
<br>

<hr width="5">


<a href="${webRoot}/intentController/list">意图管理</a>
<br>
<a href="${webRoot}/intentTemplateRelationsController/list">意图和模板的对应关系管理</a>
<br>
<a href="${webRoot}/rawDataLogController/list">收到的数据</a>
<br>





<%--hello world!!!--%>
<%--name=${name } welcome!--%>

<%--请输入语音：--%>
<%--<input type="text" name="input" id="text_id">--%>
<%--<input type="button" name="input" id="button_1" value="上传" onclick="upload()">--%>


<%--<audio src="111.mp3" id="myaudio" controls="controls" loop="false" hidden="true">--%>

<%--</audio>--%>
<%--<input type="button" onclick="autoPlay()" value="播放"/>--%>
<%--<input type="button" onclick="closePlay()" value="关闭"/>--%>








<%--
<video controls="" autoplay="" name="media"><source src="https://translate.google.cn/translate_tts?ie=UTF-8&amp;q=Law%20Master%20sends%20a%20large%20water%20SF%20algorithm&amp;tl=en&amp;total=1&amp;idx=0&amp;textlen=43&amp;tk=894805.732725&amp;client=t" type="audio/mpeg"></video>--%>


<script type="text/javascript">

    function upload() {

        var val = $('#text_id').val();


        var url = './text2voice/text?data=' + val;


        var myAuto = document.getElementById('myaudio');

        myAuto.src = url;

        myAuto.play();

        console.log(val)

    }


    function autoPlay() {
        var myAuto = document.getElementById('myaudio');
        myAuto.play();
    }
    function closePlay() {
        var myAuto = document.getElementById('myaudio');
        myAuto.pause();
        myAuto.load();
    }


</script>


</body>
</html>