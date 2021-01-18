package com.midhun.exceldownloadactivemqconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "customer_certificates", name = "customer_info")
@Getter @Setter @NoArgsConstructor @ToString
public class CustomerInfo implements Serializable {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int customerId;
    @Column(name = "username")
    private String username;
    @Column(name = "first_nm")
    @JsonProperty("firstname")
    private String firstNm;
    @Column(name = "last_nm")
    @JsonProperty("lastname")
    private String lastNm;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_nr")
    @JsonProperty("phonenr")
    private String phoneNr;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerInfos", cascade = CascadeType.ALL)
    private Set<CertificationHistory> certificationHistories;
}
