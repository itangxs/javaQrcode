package com.tangxs.javaqrcode.service;

import com.tangxs.javaqrcode.util.RedisUtil;
import com.tangxs.javaqrcode.util.SendPushPost;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author  tangxs
 */
@Component
public class AsyncTask {  
    protected final Logger logger = Logger.getLogger(this.getClass());

    //myTaskAsynPool即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
    @Async("myTaskAsyncPool")
    public void doTask(String sessionId,String url) throws InterruptedException{
        String result = SendPushPost.sendGet(url);
        RedisUtil.set(sessionId,result);
        logger.info(result);
    }    
}    