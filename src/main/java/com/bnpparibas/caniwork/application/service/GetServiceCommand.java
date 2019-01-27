package com.bnpparibas.caniwork.application.service;

import com.bnpparibas.caniwork.domain.Service;
import com.bnpparibas.caniwork.domain.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class GetServiceCommand {

    private final ServiceRepository repo;

    public GetServiceCommand(ServiceRepository repo) {
        this.repo = repo;
    }

    public Service process(int id) {
        return repo.getService(id);
    }
}
