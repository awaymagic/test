package com.away.test.listener;

import com.away.test.bean.OrderCase;
import com.away.test.event.OrderSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wei.guo
 * @date 2023/12/3
 */
@Component
public class SmsListener implements ApplicationListener<OrderSuccessEvent> {

    @Override
    public void onApplicationEvent(OrderSuccessEvent event) {
        OrderCase orderCase = event.getOrder();
        orderCase.append("SmsListener over.");
    }

}
