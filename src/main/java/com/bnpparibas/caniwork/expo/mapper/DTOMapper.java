package com.bnpparibas.caniwork.expo.mapper;

import com.bnpparibas.caniwork.domain.Service;
import com.bnpparibas.caniwork.expo.dto.ServiceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class DTOMapper extends ModelMapper {

    public DTOMapper() {
        this.typeMap(String.class, URL.class)
                .setConverter((context) -> {
                    try {
                        return new URL(context.getSource());
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public ServiceDTO toDTO(Service service) {
        return this.map(service, ServiceDTO.class);
    }

    public Service toService(ServiceDTO service) {
        return this.map(service, Service.class);
    }
}
