package com.midhun.exceldownloadactivemqconsumer.activemq;

import com.midhun.exceldownloadactivemqconsumer.dto.CustomerInfoDao;
import com.midhun.exceldownloadactivemqconsumer.model.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ActiveMQProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${active-mq.queue}")
    private String queue;

    public ResponseEntity<?> sendMessage(CustomerInfoDao message) {
        log.info("Sending message to the queue: " +queue);
        try {
            jmsTemplate.convertAndSend(queue, message);
        } catch (Exception ex) {
            log.error("Exception while sending message: ", ex);
        }
        return ResponseEntity.ok(message);
    }
}
