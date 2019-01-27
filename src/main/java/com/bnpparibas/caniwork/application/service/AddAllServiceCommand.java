package com.bnpparibas.caniwork.application.service;

import com.bnpparibas.caniwork.domain.Service;
import com.bnpparibas.caniwork.domain.repository.ServiceRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class AddAllServiceCommand {
    private final ServiceRepository repo;

    public AddAllServiceCommand(ServiceRepository repo) {
        this.repo = repo;
    }

    public List<Service> process(List<Service> services) {
        return repo.saveAll(services);
    }
}
