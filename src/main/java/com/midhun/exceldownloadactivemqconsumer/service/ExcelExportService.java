package com.midhun.exceldownloadactivemqconsumer.service;

import com.midhun.exceldownloadactivemqconsumer.Repository.FileDownloadsRepository;
import com.midhun.exceldownloadactivemqconsumer.model.CustomerInfo;
import com.midhun.exceldownloadactivemqconsumer.model.FileDownloads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ExcelExportService {
    @Autowired
    private FileDownloadsRepository fileDownloadsRepository;

    public void saveExcelToDB(byte[] doc, CustomerInfo customerInfo) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String fileName = customerInfo.getUsername() + "_certifications_history_" + dateFormat.format(new Date()) + ".xlsx";
        FileDownloads fileDownloads = new FileDownloads();
        fileDownloads.setCustomerId(customerInfo.getCustomerId());
        fileDownloads.setFileName(fileName);
        fileDownloads.setFileContent(doc);
        fileDownloads.setUploadedDate(localDateTime);
        fileDownloadsRepository.save(fileDownloads);
    }
}
