package com.chatweb.web;

import com.chatweb.comm.Const;
import com.chatweb.comm.aop.LoggerManage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController{

	@RequestMapping(value="/",method=RequestMethod.GET)
	@LoggerManage(description="首页")
	public String index(Model model){
		return "index";
	}

	@RequestMapping(value="/{url}",method=RequestMethod.GET)
	@LoggerManage(description="短地址首页")
	public String index(@PathVariable String url,Model model){
		return "index";
	}



	@RequestMapping(value="/login",method=RequestMethod.GET)
	@LoggerManage(description="登陆页面")
	public String signin() {
		return "user/login";
	}

	@RequestMapping(value="/reset-password",method=RequestMethod.GET)
	@LoggerManage(description = "重置密码页面")
	public String newPassword(String email) {
		return "user/reset-password";
	}


    @RequestMapping(value = "/admin/settings/profile",method = RequestMethod.GET)
    @LoggerManage(description = "个人资料")
    public String profile(){
        return  "admin/settings/profile";
    }



	@RequestMapping(value = "/admin/settings/users",method = RequestMethod.GET)
	@LoggerManage(description = "用户列表")
	public String users(){return  "admin/settings/users";}

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    @LoggerManage(description="sign out")
    public void logout(HttpServletResponse response, Model model){
        try {
            getSession().removeAttribute(Const.LOGIN_SESSION_KEY);
            getSession().removeAttribute(Const.LAST_REFERER);
            Cookie cookie = new Cookie(Const.LOGIN_SESSION_KEY, "");
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect("/");
        } catch (Exception ex){
            logger.error(ex.getStackTrace().toString());
        }

    }

}