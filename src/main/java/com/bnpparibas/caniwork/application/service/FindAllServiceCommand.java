package com.bnpparibas.caniwork.application.service;

import com.bnpparibas.caniwork.domain.Service;
import com.bnpparibas.caniwork.domain.repository.ServiceRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class FindAllServiceCommand {
    private final ServiceRepository repo;

    public FindAllServiceCommand(ServiceRepository repo) {
        this.repo = repo;
    }

    public List<Service> process() {
        return repo.findAllService();
    }
}
