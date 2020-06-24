package com.zg.controller;

import com.zg.socket.SocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>Title:Chatroom</p>
 * <p>@Description 聊天房间</P>
 *
 * @Author pos
 * @DATE 2020/5/6 21:00
 */
@Controller
public class Chatroom {

    @Bean//这个注解会从Spring容器拿出Bean
    public SocketHandler infoHandler() {
        return new SocketHandler();
    }

    @RequestMapping("/websocket/toLogin")
    public ModelAndView toLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("login");
    }

    @RequestMapping("/websocket/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        System.out.println(username+"登录");
        HttpSession session = request.getSession(false);
        session.setAttribute("SESSION_USERNAME", username);
        //response.sendRedirect("/quicksand/jsp/websocket.jsp");
        return new ModelAndView("ws");
    }

    @RequestMapping("/websocket/send")
    @ResponseBody
    public String send(HttpServletRequest request) {
        String username = request.getParameter("username");
        if (StringUtils.isEmpty(username)){
            infoHandler().sendMessageToUsers(new TextMessage("给所有用户发消息"));
        }else{
            infoHandler().sendMessageToUser(username, new TextMessage("给"+username+"用户发消息"));
        }
        return "success";
    }
}

