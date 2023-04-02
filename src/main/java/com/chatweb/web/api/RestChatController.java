package com.chatweb.web.api;


import com.alibaba.fastjson.JSONObject;
import com.chatweb.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p></p>
 *
 * @author wzq 2023/3/7 13:55
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2023/3/7
 * @modify by reason:{方法名}:{原因}
 */
@RestController
public class RestChatController {

    @Autowired
    private ChatService chatService;

    @RequestMapping("/createChatCompletion")
    public JSONObject createChatCompletion(HttpServletRequest request, HttpServletResponse response) {
        return chatService.createChatCompletion(request, response);
    }
} 