package com.mageeyang.eit.core.util;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;

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
    private String proxyIp;
    private int proxyPort;

    /**
     * HttpUtil构造函数
     * @param timeout   请求响应时长 单位ms
     * @param proxyIP   代理的IP地址或域名
     * @param proxyPort 代理端口
     */
    public HttpUtil(int timeout,String proxyIP,int proxyPort){
        mReqCon = RequestConfig.custom()
                .setConnectionRequestTimeout(timeout).setConnectTimeout(timeout)
                .setSocketTimeout(timeout).build();
        if(proxyIp!=null && !"".equals(proxyIp)){
            proxy = new HttpHost(proxyIP,proxyPort);
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
            mClient = HttpClients.custom().setRoutePlanner(routePlanner).build();
        }else{
            mClient = HttpClients.createDefault();
        }
    }

    public void doGet(String url){

    }
}
