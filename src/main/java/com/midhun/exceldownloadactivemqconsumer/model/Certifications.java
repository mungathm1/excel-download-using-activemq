package com.midhun.exceldownloadactivemqconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "customer_certificates", name = "certifications")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //to fix - InvalidDefinitionException: No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer
public class Certifications {
    @Id
    @Column(name = "certificate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int certificateId;
    @Column(name = "exam_number")
    @JsonProperty("examnumber")
    private String examNumber;
    @Column(name = "exam_title")
    @JsonProperty("examtitle")
    private String examTitle;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "certifications", cascade = CascadeType.ALL)
    private Set<CertificationHistory> certificationHistories;
}
