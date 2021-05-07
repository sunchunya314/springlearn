package com.demo.springlearn.service.impl;

import com.demo.springlearn.service.OilMessageService;

public class OilMessageServiceImpl implements OilMessageService {

    public void doMessage(String customer) {
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(customer + "进行了Oil按摩");
    }
}
