package com.gutousu.dynamic_switch_data_source.controller;


import com.gutousu.dynamic_switch_data_source.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController
{
    @Autowired
    private ITestService testService;

    @GetMapping("/t1")
    public String t1()
    {
        testService.t1();
        return "";
    }

    @GetMapping("/t2")
    public String t2()
    {
        testService.t2();
        return "";
    }
}
