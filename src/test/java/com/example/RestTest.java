package com.example;

import com.alibaba.fastjson.JSON;
import com.example.entity.Account;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

/**
 * Created with RestTest
 * User: pual
 * Date: 2016/10/13
 * Desc:
 */
public class RestTest {
    private static final Logger logger = Logger.getLogger(RestTest.class);
    CredentialsProvider credsProvider = new BasicCredentialsProvider();
    {
        credsProvider.setCredentials(
                new AuthScope("localhost",8088),
                new UsernamePasswordCredentials("paul", "111111"));
    }
    final CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(credsProvider).build();



    public static void main(String[] args) throws URISyntaxException {
        RestTest restTest = new RestTest();
//        URI url =  new URIBuilder().setScheme("http")
//                .setHost("localhost").setPort(8088)
//                .setPath("/index/1").build();
//        ResponseEntity<Account> result = restTest.getRestTemplate().getForEntity(url, Account.class);
        Account account = new Account();
        account.setAccountId(11L);
        account.setAccountName("selena");
        account.setUsername("谷艳");
        account.setPassword("123456");
        account.setNewpassword("111111");
//        ResponseEntity<Account> result = restTest.getRestTemplate().put("http://localhost:8088/updateAccount/11",account);
//        restTest.getRestTemplate().put("http://localhost:8088/updateAccount/11",account);
        HttpEntity<Account> httpEntity = new HttpEntity<>(account);
        ResponseEntity<Account> result = restTest.getRestTemplate().exchange("http://localhost:8088/updateAccount/11", HttpMethod.PUT,httpEntity,Account.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
    }


    public RestTemplate getRestTemplate(){
        UsernamePasswordCredentials cred = new UsernamePasswordCredentials("paul","111111");
        BasicCredentialsProvider cp = new BasicCredentialsProvider();
        cp.setCredentials(AuthScope.ANY, cred);
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(cp).build();
        ClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }

    public String httpGet(String path){
        HttpResponse httpResponse = null;
        try {
            HttpGet httpGet = new HttpGet("http://localhost:8088"+path);
            httpResponse = httpClient.execute(httpGet);
            return EntityUtils.toString(httpResponse.getEntity());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T httpGet(String path, Class<T> t){
        return JSON.parseObject(httpGet(path),t);
    }

    public String httpPost(String path){
        HttpResponse httpResponse = null;
        try {
            HttpPost httpGet = new HttpPost("http://localhost:8088"+path);
            httpResponse = httpClient.execute(httpGet);
            return EntityUtils.toString(httpResponse.getEntity());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
