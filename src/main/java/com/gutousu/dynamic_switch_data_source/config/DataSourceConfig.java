package com.gutousu.dynamic_switch_data_source.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * 配置数据源
 */
@Setter
@ConfigurationProperties(prefix = "spring.datasource")
@Configuration
public class DataSourceConfig
{
    private static final ThreadLocal<String> datasourceHolder = new ThreadLocal<>();

    private HikariDataSource primary;
    private HikariDataSource secondary;

    private static final AbstractRoutingDataSource abstractRoutingDataSource = new AbstractRoutingDataSource()
    {
        @Override
        protected Object determineCurrentLookupKey()
        {
            return datasourceHolder.get();
        }
    };

    public static void setDataSource(String sourceName)
    {
        datasourceHolder.set(sourceName);
    }

    public static void clearDataSource()
    {
        datasourceHolder.remove();
    }

    @Bean
    public DataSource dataSource()
    {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceEnum.PRIMARY.getValue(), primary);
        targetDataSources.put(DataSourceEnum.SECONDARY.getValue(), secondary);

        abstractRoutingDataSource.setTargetDataSources(targetDataSources);
        abstractRoutingDataSource.setDefaultTargetDataSource(primary);
        return abstractRoutingDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
}
