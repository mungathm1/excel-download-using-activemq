package com.midhun.exceldownloadactivemqconsumer.controller;

import com.midhun.exceldownloadactivemqconsumer.model.CustomerInfo;
import com.midhun.exceldownloadactivemqconsumer.service.CustomerCertificatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerCertificatesController {

    @Autowired
    private CustomerCertificatesService customerCertificatesService;

    @RequestMapping(method = RequestMethod.GET, value = "/rest/api/certhist/{username}")
    public ResponseEntity<?> getCustomerCerts(@PathVariable String username) {
        return ResponseEntity.ok(customerCertificatesService.getCustomerCertHist(username));
    }
}
