package com.gutousu.dynamic_switch_data_source.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class DataSourceAop
{
    @Before("@annotation(dataSource)")
    public void before(JoinPoint joinPoint, DataSource dataSource)
    {
        DataSourceConfig.setDataSource(dataSource.value().getValue());
    }

    @After("@annotation(dataSource)")
    public void after(JoinPoint joinPoint, DataSource dataSource)
    {
        DataSourceConfig.clearDataSource();
    }
}
