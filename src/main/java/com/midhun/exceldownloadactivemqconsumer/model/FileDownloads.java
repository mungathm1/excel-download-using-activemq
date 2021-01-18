package com.midhun.exceldownloadactivemqconsumer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "customer_certificates", name = "file_downloads")
@Getter @Setter @NoArgsConstructor
public class FileDownloads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_download")
    private int idDownload;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "file_name")
    private String fileName;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "file_content")
    private byte[] fileContent;
    @Column(name = "uploaded_date")
    private LocalDateTime uploadedDate;
}
