package com.midhun.exceldownloadactivemqconsumer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "customer_certificates", name = "certification_history")
@Getter @Setter @NoArgsConstructor
public class CertificationHistory {
    @Id
    @Column(name = "certification_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int certificationHistoryId;
    @Column(name = "grade_indicator")
    @JsonProperty("gradeindicator")
    private String gradeIndicator;
    @Column(name = "exam_date")
    @JsonProperty("examdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date examDate;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private CustomerInfo customerInfos;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certificate_id", referencedColumnName = "certificate_id")
    private Certifications certifications;
}
