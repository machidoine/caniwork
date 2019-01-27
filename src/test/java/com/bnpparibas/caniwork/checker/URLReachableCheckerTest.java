package com.bnpparibas.caniwork.checker;

import com.bnpparibas.caniwork.checker.result.CheckerResult;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.is;

public class URLReachableCheckerTest {

    private URLReachableChecker checker;

    @Test
    public void check_wrongUrl_shouldReturn_false() throws IOException {
        CheckerResult result = runChecker("http://badUrl424242.com");

        Assert.assertThat(result.isCorrect(), is(false));
    }

    private CheckerResult runChecker(String url) throws MalformedURLException {
        return new URLReachableChecker(new URL(url)).check();
    }

    @Test
    public void check_goodUrl_shouldReturn_true() throws IOException {
        CheckerResult result = runChecker("http://google.com");
        Assert.assertThat(result.isCorrect(), is(true));
    }
}