package per.david.demo.configuration.websocket.old;

import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;

//@Configuration
//@EnableWebSocketMessageBroker
public class WebsocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /*@Autowired
    private WebSocketFactory webSocketDecoratorFactory;

    @Autowired
    private PrincipalHandshakeHandler principalHandshakeHandler;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        *//**
         * myUrl表示 你前端到时要对应url映射
         *//*
        registry.addEndpoint("/websocket")
                .setAllowedOrigins("*")
                .setHandshakeHandler(principalHandshakeHandler)
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        *//**
         * queue 点对点
         * topic 广播
         * user 点对点前缀
         *//*
        registry.enableSimpleBroker("/queue", "/topic");
        registry.setUserDestinationPrefix("/user");
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        registration.addDecoratorFactory(webSocketDecoratorFactory);
        super.configureWebSocketTransport(registration);
    }*/
}
