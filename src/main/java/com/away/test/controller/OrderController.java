package com.away.test.controller;

import com.away.test.bean.OrderCase;
import com.away.test.event.OrderSuccessEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wei.guo
 * @date 2023/12/3
 */
@RestController
@RequestMapping("/order")
public class OrderController implements ApplicationEventPublisherAware {

    /**
     * 事件发布器
     */
    private ApplicationEventPublisher publisher;

    @GetMapping("/{type}")
    public Mono<OrderCase> orderByType(@PathVariable Integer type) {
        OrderCase orderCase = null;
        if (type == 1) {
            orderCase = OrderCase.builder()
                    .type(type)
                    .name("RTX4090ti")
                    .build();
        } else if (type == 2) {
            orderCase = OrderCase.builder()
                    .type(type)
                    .name("iPhone 15 Pro Max")
                    .build();

        }

        List<String> traces = new ArrayList<>();
        traces.add("order over.");
        assert orderCase != null;
        orderCase.setTraces(traces);

        // 推送事件
        publisher.publishEvent(new OrderSuccessEvent(orderCase));

        return Mono.just(orderCase);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

}
