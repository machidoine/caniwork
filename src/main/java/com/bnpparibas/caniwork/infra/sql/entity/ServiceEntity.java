package com.bnpparibas.caniwork.infra.sql.entity;

import com.bnpparibas.caniwork.domain.ServiceTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntity {
    @Id
    private int id;

    private String name;
    private String url;
    private ServiceTypeEnum serviceType;
}
