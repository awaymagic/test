package com.away.test.event;

import com.away.test.bean.OrderCase;
import org.springframework.context.ApplicationEvent;

/**
 * @author wei.guo
 * @date 2023/12/3
 */
public class OrderSuccessEvent extends ApplicationEvent {

    private final OrderCase orderCase;

    public OrderSuccessEvent(OrderCase orderCase) {
        super(orderCase);
        this.orderCase = orderCase;
    }

    public OrderCase getOrder() {
        return orderCase;
    }

}
