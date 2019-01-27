package com.bnpparibas.caniwork.domain.repository;

import com.bnpparibas.caniwork.domain.Service;

import java.util.List;

public interface ServiceRepository {
    Service save(Service service);
    List<Service> findAllService();
    Service getService(int id);

    List<Service> saveAll(List<Service> services);
}
