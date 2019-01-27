package com.bnpparibas.caniwork.infra.sql;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan("com.bnpparibas.caniwork.infra.sql.entity")
@EnableJpaRepositories("com.bnpparibas.caniwork.infra.sql")
public class JpaConfiguration {
}
