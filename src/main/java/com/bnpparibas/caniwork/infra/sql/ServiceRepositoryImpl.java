package com.bnpparibas.caniwork.infra.sql;

import com.bnpparibas.caniwork.domain.Service;
import com.bnpparibas.caniwork.domain.repository.ServiceRepository;
import com.bnpparibas.caniwork.infra.sql.mapper.EntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ServiceRepositoryImpl implements ServiceRepository {
    private final ServiceJpaRepository jpaRepo;
    private final EntityMapper mapper;

    public ServiceRepositoryImpl(ServiceJpaRepository jpaRepo, EntityMapper mapper) {
        this.jpaRepo = jpaRepo;
        this.mapper = mapper;
    }

    @Override
    public Service save(Service service) {
        return mapper.toService(jpaRepo.save(mapper.toEntity(service)));
    }

    @Override
    public List<Service> findAllService() {
        return jpaRepo.findAll().stream()
                .map(mapper::toService)
                .collect(Collectors.toList());
    }

    @Override
    public Service getService(int id) {
        return jpaRepo.findById(id)
                .map(mapper::toService)
                .orElseThrow(() -> new ServiceNotFoundException(id));
    }

    @Override
    public List<Service> saveAll(List<Service> services) {
        return jpaRepo.saveAll(services.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList())
                ).stream()
                .map(mapper::toService)
                .collect(Collectors.toList());
    }

    public class ServiceNotFoundException extends RuntimeException {
        public ServiceNotFoundException(int id) {
            super("Service '" + id + "' not found");
        }
    }
}
