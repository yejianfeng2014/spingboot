<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <script type="text/javascript" src="resources/jquery-3.3.1.js" charset="utf-8"></script>

</head>
<body>
<%--hello world!!!--%>
<%--name=${name } welcome!--%>

请输入语音：
<input type="text" name="input" id="text_id">
<input type="button" name="input" id="button_1" value="上传" onclick="upload()">


<audio src="111.mp3" id="myaudio" controls="controls" loop="false" hidden="true">

</audio>
<input type="button" onclick="autoPlay()" value="播放"/>
<input type="button" onclick="closePlay()" value="关闭"/>


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