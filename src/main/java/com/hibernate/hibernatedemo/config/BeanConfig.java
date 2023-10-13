package com.hibernate.hibernatedemo.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class BeanConfig {
    @Autowired
    private Environment env;

    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory() throws Exception{
        Properties properties = new Properties();
        properties.put("hibernate.dialect",env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql",env.getProperty("spring.jpa.show-sql"));
        properties.put("current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
        LocalSessionFactoryBean sessionFactory =new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan("com.hibernate.hibernatedemo");
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.afterPropertiesSet();
        return sessionFactory.getObject();
    }

    @Bean
    @Primary
    public EntityManagerFactory getEntityManagerFactory(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect",env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql",env.getProperty("spring.jpa.show-sql"));
        properties.put("current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));

        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(this.getDataSource());
        em.setPackagesToScan("com.hibernate.hibernatedemo");
        em.setJpaProperties(properties);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.afterPropertiesSet();
        return em.getObject();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }
}
