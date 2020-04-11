package com.school.message.message.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Component
public class HttpUtil {


    public CloseableHttpClient client() {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        return httpClient;
    }

    public JSONObject httpPost(URI uri, Map<String, String> params) {
        HttpPost httpPost = new HttpPost(uri);
        String strParams = JSON.toJSONString(params);
        StringEntity entity = new StringEntity(strParams, "UTF-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        JSONObject resp = null;
        try (CloseableHttpClient httpClient = this.client(); CloseableHttpResponse response = httpClient.execute(httpPost)) {
            HttpEntity responseEntity = response.getEntity();


            if (responseEntity != null) {

                String s = EntityUtils.toString(responseEntity);
                resp = JSON.parseObject(s);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resp;
    }

    public JSONObject httpGet(String url, Map<String, String> params) throws URISyntaxException {
        URI uri = this.createUri(url, params);

        HttpGet get = new HttpGet(uri);
        JSONObject response = null;
        try (CloseableHttpClient httpClient = this.client(); CloseableHttpResponse execute = httpClient.execute(get)) {
            HttpEntity entity = execute.getEntity();
            String strResult = EntityUtils.toString(entity, "utf-8");
            response = JSONObject.parseObject(strResult);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public URI createUri(String url, Map<String, String> params) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(url);

        if (params != null) {
            params.forEach((key, value) -> {
                builder.setParameter(key, value);
            });
        }
        URI uri = builder.build();
        return uri;
    }


}
