package com.midhun.exceldownloadactivemqconsumer.controller;

import com.midhun.exceldownloadactivemqconsumer.activemq.ActiveMQProducer;
import com.midhun.exceldownloadactivemqconsumer.dto.CustomerInfoDao;
import com.midhun.exceldownloadactivemqconsumer.model.CustomerInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "ProduceMessageController")
public class ProduceMessageController {
    @Autowired
    private ActiveMQProducer activeMQProducer;

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    @ApiOperation(value = "post request to send message to activemq", response = Iterable.class, tags = "sendMessage")
    public ResponseEntity sendMessage(@RequestBody CustomerInfoDao customerInfoDao) {
        ResponseEntity response = activeMQProducer.sendMessage(customerInfoDao);
        return ResponseEntity.ok(response);
    }

}
