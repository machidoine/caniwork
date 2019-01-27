package com.bnpparibas.caniwork.application.service;

import com.bnpparibas.caniwork.domain.Service;
import com.bnpparibas.caniwork.domain.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class AddServiceCommand {
    private final ServiceRepository repo;

    public AddServiceCommand(ServiceRepository repo) {
        this.repo = repo;
    }

    public Service process(Service service) {
        return repo.save(service);
    }
}
