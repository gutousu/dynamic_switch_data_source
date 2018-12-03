package com.gutousu.dynamic_switch_data_source.config;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource
{
    DataSourceEnum value();
}
