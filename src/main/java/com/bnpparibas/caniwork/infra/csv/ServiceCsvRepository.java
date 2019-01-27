package com.bnpparibas.caniwork.infra.csv;

import com.bnpparibas.caniwork.domain.Service;
import com.bnpparibas.caniwork.domain.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceCsvRepository implements ServiceRepository {

    @Value("${repository.csv.path}")
    private String csvPath;

    @Value("${repository.csv.file}")
    private String csvFile;

    @Override
    public Service save(Service service) {
        return null;
    }

    @Override
    public List<Service> findAllService() {
        return CsvUtil.readFile(this.csvPath + "/" +  this.csvFile, Service.class);
    }

    @Override
    public Service getService(int id) {
        return null;
    }

    @Override
    public List<Service> saveAll(List<Service> services) {
        return null;
    }
}
