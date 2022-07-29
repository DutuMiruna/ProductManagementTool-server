/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.main;

import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author mirun
 */
@Configuration
@ComponentScan(basePackages = {"{com.ing.main", "com.ing.main.db", "com.ing.main.dao", "com.ing.main.service", "com.ing.main.controller"})
@EnableTransactionManagement
public class ProjConfig {

    @Bean
    public LocalEntityManagerFactoryBean emf() {
        LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
        emf.setPersistenceUnitName("ro.telacad_ProductManagementTool-server_war_1.0-SNAPSHOTPU");
        return emf;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionMmanager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(emf);
        return transactionManager;
    }
}
