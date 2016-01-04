package com.mageeyang.eit.core.util;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * 该类主要用于进行与URL地址进行通讯，处理POST或GET
 * 并获取页面内容、图片、XML数据、JSON数据等
 * 同时可以设置代理服务器进行通讯
 * Created by Administrator on 2015/12/30.
 */
public class HttpUtil {
    private static final String IOERRORMESSAGE = "系统出现IO异常";
    private static final String JSONERRORMESSAGE = "JSON数据处理异常";
    private static final String ERRORMESSAGE = "服务器数据获取异常";
    private CloseableHttpClient mClient;
    private CloseableHttpResponse mRes = null;
    private RequestConfig mReqCon;
    private HttpHost proxy = null;

    /**
     * HttpUtil构造函数
     * @param timeout   请求响应时长 单位ms
     * @param proxyIP   代理的IP地址或域名
     * @param proxyPort 代理端口
     */
    public HttpUtil(int timeout,String proxyIP,int proxyPort){
        this.init(timeout,proxyIP,proxyPort);
    }
    /**
     * HttpUtil构造函数
     * @param timeout   请求响应时长 单位ms
     */
    public HttpUtil(int timeout){
        this.init(timeout, "", 0);
    }

    /**
     * HttpUtil构造函数
     * 默认请求响应时长为5秒
     */
    public HttpUtil(){
        this.init(5000, "", 0);
    }

    private void init(int timeout,String proxyIP,int proxyPort){
        mReqCon = RequestConfig.custom()
                .setConnectionRequestTimeout(timeout).setConnectTimeout(timeout)
                .setSocketTimeout(timeout).build();
        if(proxyIP!=null && !"".equals(proxyIP)){
            proxy = new HttpHost(proxyIP,proxyPort);
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
            mClient = HttpClients.custom().setRoutePlanner(routePlanner).build();
            System.out.println("设置代理服务器");
        }else{
            mClient = HttpClients.createDefault();
        }
    }

    /**
     * 关闭HttpUtil的连接对象
     */
    public void close() {
        try{
            if(mRes !=null){
                mRes.close();
            }
            if(mClient != null){
                mClient.close();
            }
        }catch(IOException e){
            System.out.println(IOERRORMESSAGE);
            e.printStackTrace();
        }

    }

    /**
     * 执行get或POST方法
     * @param url   需要获取的URL地址
     * @param method  0代表GET，1代表POST
     */
    private void excute(String url,int method){

        try{
            switch (method){
                case 0:
                    HttpGet hg = new HttpGet(url);
                    mRes = mClient.execute(hg);
                    break;
                case 1:
                    HttpPost hp = new HttpPost(url);
                    mRes = mClient.execute(hp);
                    break;
            }
        }catch(IOException e){
            System.out.println(ERRORMESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * 从URL地址获取JSON对象
     * @param url   要获取数据的URL地址
     * @return      返回JSONObject
     */
    public JSONObject getJsonObject(String url){
        JSONObject json = null;
        try{
            this.excute(url,0);
            json = new JSONObject(EntityUtils.toString(mRes.getEntity()));
        }catch(IOException e){
            System.out.println(IOERRORMESSAGE);
            e.printStackTrace();
        }catch(JSONException e){
            System.out.println(JSONERRORMESSAGE);
            e.printStackTrace();
        }finally {
            try{
                if(mRes!=null){
                    mRes.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return json;
        }
    }

    /**
     * 从URL地址获取JSON数组
     * @param url   要获取数据的URL地址
     * @return      返回JSONArray
     */
    public JSONArray getJsonArray(String url){
        JSONArray json = null;
        try{
            this.excute(url,0);
            json = new JSONArray(EntityUtils.toString(mRes.getEntity()));
        }catch(IOException e){
            System.out.println(IOERRORMESSAGE);
            e.printStackTrace();
        }catch(JSONException e){
            System.out.println(JSONERRORMESSAGE);
            e.printStackTrace();
        }finally {
            try{
                if(mRes!=null){
                    mRes.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return json;
        }
    }
}
