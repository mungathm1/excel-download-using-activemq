package com.midhun.exceldownloadactivemqconsumer.controller;

import com.midhun.exceldownloadactivemqconsumer.model.CertificationHistory;
import com.midhun.exceldownloadactivemqconsumer.model.CustomerInfo;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class ExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private CustomerInfo customerInfo;

    public ExcelExporter(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Customer Certifications");
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if(value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if(value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void excelHeader() {
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Username",style);
        createCell(row, 1, "First Name",style);
        createCell(row, 2, "Last Name",style);
        createCell(row, 3, "Email",style);
        createCell(row, 4, "Exam Number",style);
        createCell(row, 5, "Exam Title",style);
        createCell(row, 6, "Grade Indicator",style);
        createCell(row, 7, "Exam Date",style);

    }

    private void excelContent() {
        int rowCount = 1;
        int columnCount = 0;
        Date examDate;
        DateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
        Row row;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for(CertificationHistory certificationHistory : customerInfo.getCertificationHistories()) {
            columnCount = 0;
            row = sheet.createRow(rowCount++);
            examDate = certificationHistory.getExamDate();

            createCell(row, columnCount++, customerInfo.getUsername(),style);
            createCell(row, columnCount++, customerInfo.getFirstNm(),style);
            createCell(row, columnCount++, customerInfo.getLastNm(),style);
            createCell(row, columnCount++, customerInfo.getEmail(),style);
            createCell(row, columnCount++, certificationHistory.getCertifications().getExamNumber(),style);
            createCell(row, columnCount++, certificationHistory.getCertifications().getExamTitle(),style);
            createCell(row, columnCount++, certificationHistory.getGradeIndicator(),style);
            createCell(row, columnCount++, dateFormatter.format(examDate),style);
        }

    }

    public ByteArrayOutputStream exportToExcel() throws IOException {
        excelHeader();
        excelContent();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        return out;
    }

}
