package com.example.demo;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yejianfeng on 2018/11/5.
 *
 * 这个是翻译功能，这个调试通过了
 *
 */
public class Google {


    public static void main(String[] args) throws Exception {
        String from = "zh-CN";
        String to = "en";
        String q = "今天星期几？";
        String url = "http://translate.google.cn/translate_a/single";

        String tk = token(q);

        Map<String, String> params = new HashMap<String, String>();
        params.put("client", "t");
        params.put("sl", from);
        params.put("tl", to);
        params.put("hl", "zh-CN");
        params.put("dt", "at");
        params.put("dt", "bd");
        params.put("dt", "ex");
        params.put("dt", "ld");
        params.put("dt", "md");
        params.put("dt", "qca");
        params.put("dt", "rw");
        params.put("dt", "rm");
        params.put("dt", "ss");
        params.put("dt", "t");
        params.put("ie", "UTF-8");
        params.put("oe", "UTF-8");
        params.put("source", "btn");
        params.put("ssel", "0");
        params.put("tsel", "0");
        params.put("kc", "0");
        params.put("tk", tk);
        params.put("q", q);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        URIBuilder uri = new URIBuilder(url);
        for (String key : params.keySet()) {
            String value = params.get(key);
            uri.addParameter(key, value);
        }
        HttpUriRequest request = new HttpGet(uri.toString());
        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();

        String result = EntityUtils.toString(entity, "utf-8");

        System.out.println(result);

        EntityUtils.consume(entity);
        response.getEntity().getContent().close();
        response.close();
    }

    private static String token(String value) {
        String result = "";

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        try {
            FileReader reader = new FileReader("D:\\git_cangku\\gTTS4j\\src\\main\\reource\\Google.js");
            engine.eval(reader);

            if (engine instanceof Invocable) {
                Invocable invoke = (Invocable) engine;
                result = String.valueOf(invoke.invokeFunction("token", value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
