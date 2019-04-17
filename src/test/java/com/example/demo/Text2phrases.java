package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text2phrases {


    public static void main(String[] args) {


        String sss = "i have not received it. nothing was delivered. i want my money back.";

        String[] strings = splitSentence(sss);

        System.out.println(strings.length);
        
        for (String string : strings) {
            System.out.println(string);
        }

    }



    /**
     * 根据标点符号进行句子拆分，并且保留句子结尾符号
     *
     */

    // TODO: 2019/4/9  add this method to use template get id 
    
    public static String[] splitSentence(String cmt){
        /*正则表达式：句子结束符*/
        String regEx=",|\\.|\\?|!|:|;|~|，|：|。|！|；|？";
        Pattern p =Pattern.compile(regEx);
        Matcher m = p.matcher(cmt);
        /*按照句子结束符分割句子*/
        String[] words = p.split(cmt);
        /*将句子结束符连接到相应的句子后*/
      /*  if(words.length > 0)
        {
            int count = 0;
            while(count < words.length)
            {
                if(m.find())
                {
                    words[count] += m.group();
                }
                count++;
            }
        }*/
        /*输出结果*/
        return words;
    }

}
