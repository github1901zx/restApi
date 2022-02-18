package com.spring.rest.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.spring.rest"})
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {
    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:7777/bd_emp?useSSL=false");
            dataSource.setUser("root");
            dataSource.setPassword("root19011994");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.spring.rest.entity");
        Properties hProperty = new Properties();
        hProperty.setProperty("hibernate.dialect"
                ,"org.hibernate.dialect.MySQLDialect");
        hProperty.setProperty("hibernate.show_sql"
                ,"true");
        sessionFactory.setHibernateProperties(hProperty);

    return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
    }

}
