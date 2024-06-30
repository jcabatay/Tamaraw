package com.ascii274.login.config;

import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Getter
@Setter
@Configuration
@EnableJpaRepositories("com.ascii274.login.config")
public class JpaConfiguration {

    @Autowired
    private MySQLConfig mySQLConfig;

//    Dotenv dotenv = Dotenv.configure()
//            .directory("./Tamaraw-LoginServices")
//            .ignoreIfMalformed()
//            .ignoreIfMissing()
//            .load();


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:" + mySQLConfig.getMYSQL_PORT() + "/" + mySQLConfig.getMysqlDatabase() + "?serverTimezone=UTC");
        dataSource.setUsername( mySQLConfig.getMYSQL_USER());
        dataSource.setPassword( mySQLConfig.getMYSQL_PASSWORD());
        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setGenerateDdl(true);
        return jpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
        lemfb.setDataSource(dataSource());
        lemfb.setJpaVendorAdapter(jpaVendorAdapter());
        lemfb.setPackagesToScan( mySQLConfig.getENTITY_TO_SCAN());
        return lemfb;
    }
}
