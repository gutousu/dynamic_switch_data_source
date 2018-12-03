package com.gutousu.dynamic_switch_data_source.service.impl;

import com.gutousu.dynamic_switch_data_source.config.DataSource;
import com.gutousu.dynamic_switch_data_source.config.DataSourceEnum;
import com.gutousu.dynamic_switch_data_source.repository.IUserRepository;
import com.gutousu.dynamic_switch_data_source.service.ITestService;
import com.gutousu.dynamic_switch_data_source.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class TestService implements ITestService
{
    @Autowired
    private IUserRepository userRepository;

    @DataSource(value = DataSourceEnum.SECONDARY)
    //@Transactional
    public String t1()
    {
        user user = userRepository.save(new user("张三",21));
        System.out.print("");
        return "";
    }

    @DataSource(value = DataSourceEnum.PRIMARY)
    @Transactional
    public String t2()
    {
        user user = userRepository.save(new user("张三",21));
        System.out.print("");
        return "";
    }
}
