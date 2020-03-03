package ru.hh.backend;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.backend.Resource.CompanyResource;
import ru.hh.nab.hibernate.NabHibernateProdConfig;
import ru.hh.nab.starter.NabProdConfig;

@Configuration
@Import({
        NabProdConfig.class,
        NabHibernateProdConfig.class,
        CommonConfig.class
})
@ComponentScan(basePackages = "ru.hh.backend")
public class AppConfig {
}
