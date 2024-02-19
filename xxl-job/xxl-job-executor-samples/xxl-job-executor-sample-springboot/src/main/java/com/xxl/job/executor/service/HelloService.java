package com.xxl.job.executor.service;

import org.springframework.stereotype.Service;

/**
 * @author: msy
 * @create: 2024-02-19
 **/
@Service
public class HelloService {

    public void methodA(){
        System.out.println("执行MethodA的方法");
    }
    public void methodB(){
        System.out.println("执行MethodB的方法");
    }
}
