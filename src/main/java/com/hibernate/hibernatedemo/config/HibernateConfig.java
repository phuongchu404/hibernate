//package com.hibernate.hibernatedemo.config;
//
//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.convention.MatchingStrategies;
//import org.modelmapper.spi.MatchingStrategy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//public class HibernateConfig {
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory(){
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("com.hibernate.hibernatedemo");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }
//    @Bean
//    public DataSource dataSource(){
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/user_test");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager hibernateTransactionManager(){
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }
//    private final Properties hibernateProperties(){
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
//        return hibernateProperties;
//    }
//

//}
