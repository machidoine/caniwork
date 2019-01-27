package com.bnpparibas.caniwork.expo.dto;

import com.bnpparibas.caniwork.domain.ServiceTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDTO {
    private int id;
    private String name;
    private ServiceTypeEnum type;
    private String url;
}
