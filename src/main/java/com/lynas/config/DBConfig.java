package com.lynas.config;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by lynas on 12/7/2016
 */

@Configuration
@EnableNeo4jRepositories("com.lynas.repo")
@EnableTransactionManagement
public class DBConfig extends Neo4jConfiguration{

    @Bean
    @Override
    public SessionFactory getSessionFactory() {
        System.out.println("22222222222222222222222222222222");
        return new SessionFactory(getConfiguration(), "com.lynas.model");
    }


    @Bean
    @Override
    public Session getSession() throws Exception {
        System.out.println("111111111111111111111111111111111111");

        return super.getSession();
    }

    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration(){
        org.neo4j.ogm.config.Configuration conf = new org.neo4j.ogm.config.Configuration();
        conf.driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.bolt.driver.BoltDriver")
                .setConnectionPoolSize(150)
                .setURI("bolt://neo4j:123456@localhost:7687");
        System.out.println("===========================");
        System.out.println(conf.toString());
        System.out.println("===========================");
        return conf;
    }
}
