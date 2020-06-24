package com.zg.socket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>Title:SocketHandshakeInterceptor</p>
 * <p>@Description 类注释</P>
 *
 * @Author pos
 * @DATE 2020/5/7 11:20
 */
@Component
public class SocketHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        if (serverHttpRequest instanceof ServletServerHttpRequest) {
            HttpServletRequest httpServletRequest = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();
            HttpSession session = httpServletRequest.getSession(true);
            if (session != null) {
                //一般直接保存user实体
                String userName = (String) session.getAttribute("SESSION_USERNAME");
                if (userName != null) {
                    map.put("WEBSOCKET_USERID", userName);
                }
            }
        }
        return true;

    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}

// @Override
//    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
//                                   Map<String, Object> attributes) throws Exception {
//        System.out.println("Before Handshake");
//        if (request instanceof ServletServerHttpRequest) {
//            System.out.println("握手成功");
//            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
//            HttpSession session = servletRequest.getServletRequest().getSession(false);
//            if (session != null) {
//                //使用userName区分WebSocketHandler，以便定向发送消息
//                String userName = (String) session.getAttribute("SESSION_USERNAME");  //一般直接保存user实体
//                if (userName != null) {
//                    attributes.put("WEBSOCKET_USERID", userName);
//                }
//
//            }
//        }
//        return super.beforeHandshake(request, response, wsHandler, attributes);
//    }
//    @Override
//    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
//        //握手后的操作
//        super.afterHandshake(request, response, wsHandler, ex);
//    }