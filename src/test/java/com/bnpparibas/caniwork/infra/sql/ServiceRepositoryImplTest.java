package com.bnpparibas.caniwork.infra.sql;

import com.bnpparibas.caniwork.domain.Service;
import com.bnpparibas.caniwork.domain.ServiceTypeEnum;
import com.bnpparibas.caniwork.domain.repository.ServiceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceRepositoryImplTest {

    @SpringBootApplication
    static class App { }

    @Autowired
    private ServiceRepository repo;

    @Test
    public void findAllService() throws MalformedURLException {
        repo.save(Service.builder()
                .serviceType(ServiceTypeEnum.HTTP)
                .url(new URL("http://google.com"))
                .name("Google")
                .build());

        List<Service> services = repo.findAllService();
        assertThat(services.get(0).getName(), is("Google"));
        assertThat(services.get(0).getUrl(), is(new URL("http://google.com")));
        assertThat(services.get(0).getServiceType(), is(ServiceTypeEnum.HTTP));
    }
}
