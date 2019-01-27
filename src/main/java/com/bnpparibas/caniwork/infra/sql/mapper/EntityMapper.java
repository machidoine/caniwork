package com.bnpparibas.caniwork.infra.sql.mapper;

import com.bnpparibas.caniwork.domain.Service;
import com.bnpparibas.caniwork.infra.sql.entity.ServiceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class EntityMapper extends ModelMapper {

    public EntityMapper() {
        this.typeMap(String.class, URL.class)
                .setConverter((context) -> {
                    try {
                        return new URL(context.getSource());
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public Service toService(ServiceEntity entity) {
        return this.map(entity, Service.class);
    }

    public ServiceEntity toEntity(Service service) {
        return this.map(service, ServiceEntity.class);
    }
}
