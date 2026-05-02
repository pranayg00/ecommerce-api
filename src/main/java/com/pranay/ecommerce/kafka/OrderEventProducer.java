package com.pranay.ecommerce.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String ORDER_TOPIC = "order-events";
    private static final String PAYMENT_TOPIC = "payment-events";

    public void sendOrderCreatedEvent(Long orderId, String userEmail) {
        String message = String.format(
            "{\"event\":\"ORDER_CREATED\",\"orderId\":%d,\"userEmail\":\"%s\"}",
            orderId, userEmail
        );
        kafkaTemplate.send(ORDER_TOPIC, message);
        log.info("Order created event sent for orderId: {}", orderId);
    }

    public void sendOrderStatusEvent(Long orderId, String status) {
        String message = String.format(
            "{\"event\":\"ORDER_STATUS_UPDATED\",\"orderId\":%d,\"status\":\"%s\"}",
            orderId, status
        );
        kafkaTemplate.send(ORDER_TOPIC, message);
        log.info("Order status event sent: orderId={}, status={}", orderId, status);
    }

    public void sendPaymentEvent(Long orderId, String status) {
        String message = String.format(
            "{\"event\":\"PAYMENT_%s\",\"orderId\":%d}",
            status, orderId
        );
        kafkaTemplate.send(PAYMENT_TOPIC, message);
        log.info("Payment event sent: orderId={}, status={}", orderId, status);
    }
}
