package com.example.springBootDemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "saasEntityManagerFactory", transactionManagerRef = "saastransactionManager", basePackages = {
        "com.example.springBootDemo.dao" })
public class SaasDBRepository {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("SaasDB")
    private DataSource datasource;

    @Bean(name = "saasEntityManagerFactory")
    @Qualifier("saasEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean saasEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(datasource).properties(getVendorProperties(datasource))
                .packages("com.huifenqi.saas.context.entity.saas").persistenceUnit("saas").build();
    }

    @Bean(name = "saasEntityManager")
    @Qualifier("saasEntityManager")
    @Primary
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return saasEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "saastransactionManager")
    @Qualifier("saastransactionManager")
    @Primary
    public PlatformTransactionManager saasTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(saasEntityManagerFactory(builder).getObject());
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }
}