package com.midhun.exceldownloadactivemqconsumer.service;

import com.midhun.exceldownloadactivemqconsumer.Repository.CustomerInfoRepository;
import com.midhun.exceldownloadactivemqconsumer.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCertificatesService {
    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    public CustomerInfo getCustomerCertHist(String username) {
        return customerInfoRepository.findByUsername(username);
    }
}
