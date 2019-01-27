package com.bnpparibas.caniwork.infra.sql;

import com.bnpparibas.caniwork.infra.sql.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceJpaRepository extends JpaRepository<ServiceEntity, Integer> {
}
