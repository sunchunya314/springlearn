package com.demo.springlearn.service.impl;

import com.demo.springlearn.service.FullBodyMessageService;

public class FullBodyMessageServiceImpl implements FullBodyMessageService {

    public void doMessage(String customer) {

        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(customer + "进行了FullBody按摩");
    }

    public void doBigMessage(String customer) {
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(customer + "进行了FullBody Big按摩");
    }
}
