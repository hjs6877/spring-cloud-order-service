package com.itvillage.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
public class OrderHandler {
    public Mono<ServerResponse> getOrder(ServerRequest request) {
        long orderId = Long.parseLong(request.pathVariable("order-id"));
        log.info("# orderId: {}", orderId);
        return ServerResponse.ok()
                .bodyValue(new Order(orderId, Order.OrderState.COMPLETED));
    }
    public Mono<ServerResponse> getOrdersByMember(ServerRequest request) {
        long memberId = Long.parseLong(request.pathVariable("member-id"));

        List<Order> orders = List.of(
                new Order(1L, Order.OrderState.COMPLETED),
                new Order(2L, Order.OrderState.COMPLETED)
        );

        return ServerResponse
                .ok()
                .bodyValue(orders);
    }
}
