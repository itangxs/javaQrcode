package com.tangxs.javaqrcode.controller;

import com.tangxs.javaqrcode.service.AsyncTask;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.tangxs.javaqrcode.util.GetWeiXinCode;
import com.tangxs.javaqrcode.util.SendPushPost;

import javax.servlet.http.HttpSession;

/**
 * @author tangxs
 * @date 2017/10/31 15:29
 */
@Controller
public class GetWeChatOpenIdController {

    @Autowired
    AsyncTask asyncTask;
    @RequestMapping("/index")
    public ModelAndView index(HttpSession session)
    {
            String sessionId = session.getId();
            System.out.println("sessionId = [" + sessionId + "]");
            ModelAndView view = new ModelAndView("index");
            view.addObject("sessionId",sessionId);
            try
            {
                asyncTask.doTask(sessionId,null);
            }
            catch (Exception e)
            {
                System.out.println("Exception = [" + e.getMessage() + "]");
            }
            return view;
    }

    @RequestMapping("/getCode")
    public  @ResponseBody JSONObject getCode()
    {
            JSONObject json = new JSONObject();
            String doRequest = GetWeiXinCode.getCodeRequestByBase("wx2c0f837207af1e64","http://liberty.tunnel.qydev.com/getOpenId");
            json.put("redirect" ,doRequest);
            return json;
    }

    @RequestMapping(value = "/getOpenId")
    public @ResponseBody JSONObject getOpenId(String code)
    {
        System.out.println("code = [" + code + "]");
        String currentOpenIdurl = GetWeiXinCode.getCurrentOpenId(code,"wx2c0f837207af1e64","99ff1726ca10b63a45ab6699802ad55d");
        String result = SendPushPost.sendGet(currentOpenIdurl);
        JSONObject httpRequest = JSONObject.fromObject(result);
        return httpRequest;
    }
}
