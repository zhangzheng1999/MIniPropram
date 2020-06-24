package com.zg.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Title:Login</p>
 * <p>@Description 登录/P>
 *
 * @Author pos
 * @DATE 2020/5/28 17:16
 */
@Controller
public class Login {
    /**
     * @Description: 登录页面
     * @return: org.springframework.web.servlet.ModelAndView
     * @Param: []
     * @Date: 2020/5/29 15:06
     **/
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * @Description: 主页
     * @return: java.lang.String
     * @Param: [name]
     * @Date: 2020/5/29 16:48
     **/
    @RequestMapping("/index")
    public String index(@RequestParam(value = "userName") String userName){
        System.out.println(userName);
        return "/index";
    }
}
