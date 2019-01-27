package com.bnpparibas.caniwork.expo.cli;

import com.bnpparibas.caniwork.application.checkengine.RunCheckCommand;
import com.bnpparibas.caniwork.checker.result.CheckerResult;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class CanIWorkCommandLineRunner implements CommandLineRunner {

    private final RunCheckCommand runCheckCommand;

    public CanIWorkCommandLineRunner(RunCheckCommand runCheckCommand) {
        this.runCheckCommand = runCheckCommand;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("all args: " + args);

        List<CheckerResult> result = runCheckCommand.process();

        log.info(result.toString());
    }
}
