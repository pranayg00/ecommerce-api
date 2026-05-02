package com.pranay.ecommerce.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderEventConsumer {

    @KafkaListener(topics = "order-events", groupId = "ecommerce-group")
    public void consumeOrderEvent(String message) {
        log.info("Received order event: {}", message);
        processOrderEvent(message);
    }

    @KafkaListener(topics = "payment-events", groupId = "ecommerce-group")
    public void consumePaymentEvent(String message) {
        log.info("Received payment event: {}", message);
        processPaymentEvent(message);
    }

    private void processOrderEvent(String message) {
        if (message.contains("ORDER_CREATED")) {
            log.info("Processing new order creation: {}", message);
        } else if (message.contains("ORDER_STATUS_UPDATED")) {
            log.info("Processing order status update: {}", message);
        }
    }

    private void processPaymentEvent(String message) {
        if (message.contains("PAYMENT_SUCCESS")) {
            log.info("Payment successful, confirming order: {}", message);
        } else if (message.contains("PAYMENT_FAILED")) {
            log.info("Payment failed, cancelling order: {}", message);
        }
    }
}
