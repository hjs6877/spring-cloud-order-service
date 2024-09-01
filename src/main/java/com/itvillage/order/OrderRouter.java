package com.itvillage.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class OrderRouter {
    @Bean
    public RouterFunction<?> routeOrder(OrderHandler handler) {
        return route()
                .GET("/orders/{order-id}", handler::getOrder)
                .build();
    }
}
