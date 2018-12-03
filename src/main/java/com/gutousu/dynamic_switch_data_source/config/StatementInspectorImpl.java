package com.gutousu.dynamic_switch_data_source.config;

import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.stereotype.Component;


@Component
public class StatementInspectorImpl implements StatementInspector
{

    @Override
    public String inspect(String sql)
    {
        return sql;
    }
}
