package com.away.test.listener;


import com.away.test.bean.OrderCase;
import com.away.test.event.OrderSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author wei.guo
 * @date 2023/12/3
 */
@Component
public class CountSalesListener {

    @Async
    @Order(2)
    @EventListener(value = OrderSuccessEvent.class, condition = "#event.order.name.equals(\"iPhone 15 Pro Max\")")
    public void onListenOrder1(OrderSuccessEvent event) {
        OrderCase orderCase = event.getOrder();
        orderCase.append("First CountSalesListener onListenOrder over.");
        System.out.println("onListenOrder1 over.");
    }

    @Async
    @Order(1)
    @EventListener(value = OrderSuccessEvent.class, condition = "#event.order.type == 2 ")
    public void onListenOrder2(OrderSuccessEvent event) throws InterruptedException {
        OrderCase orderCase = event.getOrder();
        orderCase.append("Second CountSalesListener onListenOrder over.");
        Thread.sleep(1000);
        System.out.println("onListenOrder2 over.");
    }

}
