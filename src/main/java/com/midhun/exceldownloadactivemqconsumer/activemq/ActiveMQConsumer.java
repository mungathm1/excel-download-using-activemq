package com.midhun.exceldownloadactivemqconsumer.activemq;

import com.midhun.exceldownloadactivemqconsumer.controller.ExcelExportController;
import com.midhun.exceldownloadactivemqconsumer.dto.CustomerInfoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class ActiveMQConsumer implements MessageListener {
    @Autowired
    private ExcelExportController excelExportController;

    @Override
    @JmsListener(destination = "${active-mq.queue}")
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            CustomerInfoDao customerInfoDao = (CustomerInfoDao) objectMessage.getObject();
            log.info("Received Message: " +customerInfoDao.getUsername());
            excelExportController.exportCustomerCertificates(customerInfoDao.getUsername());
        } catch (Exception e) {
            log.error("Error while receiving message: " +e);
        }
    }
}
