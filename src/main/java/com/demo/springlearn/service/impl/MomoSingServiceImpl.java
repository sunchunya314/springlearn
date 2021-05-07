package com.demo.springlearn.service.impl;

import com.demo.springlearn.service.MomoSingService;

public class MomoSingServiceImpl implements MomoSingService {

    public void sing(String customer) {

        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(customer + "进行了MomoSing服务");
    }
}
