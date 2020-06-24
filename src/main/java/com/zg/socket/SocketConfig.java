package com.zg.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;


/**
 * <p>Title:SocketConfig</p>
 * <p>@Description 类注释</P>
 *
 * @Author pos
 * @DATE 2020/5/7 11:16
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class SocketConfig  implements WebSocketConfigurer{

//    @Autowired
//    private SocketHandshakeInterceptor socketHandshakeInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        //springwebsocket 4.1.5版本前默认支持跨域访问，之后的版本默认不支持跨域，需要设置.setAllowedOrigins("*")
        registry.addHandler(wsHandler(),"/websocket/socketServer.action")
                .addInterceptors(new SocketHandshakeInterceptor())
                .setAllowedOrigins("*");
        //旧版本浏览器
        registry.addHandler(wsHandler(), "/sockjs/socketServer.action")
                .setAllowedOrigins("*")
                .addInterceptors(new SocketHandshakeInterceptor()).withSockJS();
    }

    @Bean
    public WebSocketHandler wsHandler(){
        return new SocketHandler ();
    }
}
