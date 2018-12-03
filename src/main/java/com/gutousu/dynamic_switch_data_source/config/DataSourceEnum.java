package com.gutousu.dynamic_switch_data_source.config;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum DataSourceEnum
{
    PRIMARY("primary"),
    SECONDARY("secondary");

    private String value;
}
