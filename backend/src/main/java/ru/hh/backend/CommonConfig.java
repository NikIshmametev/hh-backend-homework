package ru.hh.backend;

import ru.hh.backend.Entity.Company;
import ru.hh.backend.Entity.Resume;
import ru.hh.backend.Entity.User;
import ru.hh.backend.Entity.Vacancy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.common.properties.FileSettings;
import ru.hh.nab.datasource.DataSourceFactory;
import ru.hh.nab.datasource.DataSourceType;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.hibernate.NabHibernateCommonConfig;
import ru.hh.nab.starter.NabCommonConfig;

import javax.sql.DataSource;

@Configuration
@Import({
        NabCommonConfig.class,
        NabHibernateCommonConfig.class
})
public class CommonConfig {

    @Bean
    public MappingConfig mappingConfig() {
        return new MappingConfig(Company.class, Resume.class, User.class, Vacancy.class);
    }

    @Bean
    DataSource dataSource(DataSourceFactory dataSourceFactory, FileSettings settings) {
        return dataSourceFactory.create(DataSourceType.MASTER, false, settings);
    }
}
