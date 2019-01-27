package com.bnpparibas.caniwork.checker;

import com.bnpparibas.caniwork.checker.result.CheckerResult;
import com.bnpparibas.caniwork.domain.Service;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CheckerEngine {
    public List<CheckerResult> check(List<Service> services) {
        return services.stream()
                .map(CheckerFactory::createChecker)
                .map(Checker::check)
                .collect(Collectors.toList());
    }
}
