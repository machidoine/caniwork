package com.bnpparibas.caniwork.checker;

import com.bnpparibas.caniwork.checker.result.CheckerResult;
import com.bnpparibas.caniwork.domain.Service;
import com.bnpparibas.caniwork.domain.ServiceTypeEnum;
import com.google.common.collect.Lists;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;

public class CheckerEngineTest {
    private CheckerEngine engine;

    @Before
    public void setUp() throws Exception {
        this.engine = new CheckerEngine();
    }

    @Test
    public void runTwoCheck_shouldWork() throws MalformedURLException {
        List<CheckerResult> results = engine.check(Lists.newArrayList(
                Service.builder()
                        .serviceType(ServiceTypeEnum.HTTP)
                        .url(new URL("http://badURL424242"))
                        .build(),
                Service.builder()
                        .serviceType(ServiceTypeEnum.HTTP)
                        .url(new URL("http://google.com"))
                        .build()));

        assertThat(results.get(0).isCorrect(), CoreMatchers.is(false));
        assertThat(results.get(1).isCorrect(), CoreMatchers.is(true));
    }
}