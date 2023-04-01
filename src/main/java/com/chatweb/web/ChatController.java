package com.chatweb.web;

import com.chatweb.comm.aop.LoggerManage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ChatController extends BaseController {

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    @LoggerManage(description = "首页")
    public String index(Model model) {
        return "chat";
    }

}