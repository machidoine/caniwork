package com.bnpparibas.caniwork.checker.result;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UrlCheckResult implements CheckerResult {
    private int responseCode;
    private Exception exception;
    private String url;

    public boolean isReachable() {
        return exception == null && responseCode >= 200 && responseCode <= 399;
    }

    @Override
    public boolean isCorrect() {
        return isReachable();
    }

    @Override
    public String getUrl() {
        return this.url;
    }
}
