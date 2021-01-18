package com.midhun.exceldownloadactivemqconsumer.dto;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
public class CustomerInfoDao implements Serializable {
    private static final long serialVersionUID = 300002228479017363L;

    private String username;
    private String email;
    private String firstNm;
    private String lastNm;
    private String phoneNr;
}
