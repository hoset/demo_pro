package com.school.message.message.weixin;

import com.alibaba.fastjson.JSONObject;
import com.school.message.message.ISendMessage;
import com.school.message.message.http.HttpUtil;
import com.school.message.message.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SendWeixin implements ISendMessage {


    private HttpUtil httpUtil;

    @Autowired
    public SendWeixin(HttpUtil httpUtil) {
        this.httpUtil = httpUtil;
    }

    private String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token";

    private String appid = "wx017e9e6ae5eacd6a";
    private String secret = "a23b20b42f51cce9ab159d145e892f96";
    private static String accessToken = "";
    private static long expiresIn = 0;
    private static long tokenTime = 0;


    @Override
    public void send(Message message) {

    }


    public String getAccessToken() {
        long sn = System.currentTimeMillis();

        if (sn > tokenTime + expiresIn || accessToken == null) { // 过期或者无效
            tokenTime = sn;
            Map<String, String> accessTokenParams = new HashMap<>();

            accessTokenParams.put("grant_type", "client_credential");
            accessTokenParams.put("appid", appid);
            accessTokenParams.put("secret", secret);

            try {
                JSONObject jsonObject = httpUtil.httpGet(tokenUrl, accessTokenParams);

                accessToken = jsonObject.getString("access_token");
                expiresIn = jsonObject.getLongValue("expires_in");
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        return accessToken;
    }


    public JSONObject getOpenId() throws URISyntaxException {
//        https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID
//        https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN
        Map<String,String> params = new HashMap<>();
        String accessToken = getAccessToken();
        System.out.println("token"+accessToken);
        params.put("access_token", accessToken);
        params.put("next_openid", "NEXT_OPENID");

        URI uri = httpUtil.createUri("https://api.weixin.qq.com/cgi-bin/user/info/batchget", params);
        JSONObject jsonObject = httpUtil.httpPost(uri,new HashMap<>());

        return jsonObject;
    }




}
