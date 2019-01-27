package com.bnpparibas.caniwork.domain;

import lombok.*;

import java.net.URL;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Service {
    private int id;

    private String name;
    private URL url;
    private ServiceTypeEnum serviceType;
}
