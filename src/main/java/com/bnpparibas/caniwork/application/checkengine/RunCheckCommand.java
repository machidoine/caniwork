package com.bnpparibas.caniwork.application.checkengine;

import com.bnpparibas.caniwork.checker.CheckerEngine;
import com.bnpparibas.caniwork.checker.result.CheckerResult;
import com.bnpparibas.caniwork.domain.repository.ServiceRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RunCheckCommand {
    private final CheckerEngine engine;
    private final ServiceRepository repo;

    public RunCheckCommand(CheckerEngine engine, ServiceRepository repo) {
        this.engine = engine;
        this.repo = repo;
    }

    public List<CheckerResult> process() {
        return engine.check(repo.findAllService());
    }
}
