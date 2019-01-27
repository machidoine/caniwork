package com.bnpparibas.caniwork.checker;

import com.bnpparibas.caniwork.domain.Service;
import com.bnpparibas.caniwork.domain.ServiceTypeEnum;
import com.google.common.collect.ImmutableMap;

import java.net.URL;
import java.util.Map;

import static com.bnpparibas.caniwork.domain.ServiceTypeEnum.HTTP;

public class CheckerFactory {
    private static Map<ServiceTypeEnum, Class<? extends Checker>> m = ImmutableMap.<ServiceTypeEnum,  Class<? extends Checker>> builder()
            .put(HTTP, URLReachableChecker.class)
            .build();

    public static Checker createChecker(Service service) {
        try {
            return m.get(service.getServiceType())
                    .getDeclaredConstructor(URL.class)
                    .newInstance(service.getUrl());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
