package com.midhun.exceldownloadactivemqconsumer.controller;

import com.midhun.exceldownloadactivemqconsumer.Repository.FileDownloadsRepository;
import com.midhun.exceldownloadactivemqconsumer.model.CustomerInfo;
import com.midhun.exceldownloadactivemqconsumer.service.CustomerCertificatesService;
import com.midhun.exceldownloadactivemqconsumer.service.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class ExcelExportController {
    @Autowired
    private CustomerCertificatesService customerCertificatesService;

    @Autowired
    private ExcelExportService excelExportService;

    @Transactional
    public void exportCustomerCertificates(String username) {
        CustomerInfo customerInfo = customerCertificatesService.getCustomerCertHist(username);
        ExcelExporter excelExporter = new ExcelExporter(customerInfo);
        try {
            ByteArrayOutputStream out = excelExporter.exportToExcel();
            byte[] doc = out.toByteArray();
            excelExportService.saveExcelToDB(doc, customerInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
