package com.chatweb.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ChatService {
    public JSONObject createChatCompletion(HttpServletRequest request, HttpServletResponse response);
}
