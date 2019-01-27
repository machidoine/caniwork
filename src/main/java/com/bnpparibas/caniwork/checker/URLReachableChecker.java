package com.bnpparibas.caniwork.checker;

import com.bnpparibas.caniwork.checker.result.CheckerResult;
import com.bnpparibas.caniwork.checker.result.UrlCheckResult;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLReachableChecker implements Checker {

    private final URL url;

    public URLReachableChecker(URL url) {
        this.url = url;
    }

    @Override
    public CheckerResult check()  {
        int responseCode = 0;

        try {
            HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
            connection.setRequestMethod("GET");
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
            return UrlCheckResult.builder()
                    .exception(e)
                    .url(url.toString())
                    .build();
        }

        return UrlCheckResult.builder()
                .responseCode(responseCode)
                .url(url.toString())
                .build();
    }

}
