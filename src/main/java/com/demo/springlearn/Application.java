package com.demo.springlearn;

import com.demo.springlearn.advice.TimeCsAdvice;
import com.demo.springlearn.aspect.Aspect;
import com.demo.springlearn.aspect.JoinPoint;
import com.demo.springlearn.base.IocContainer;
import com.demo.springlearn.service.FullBodyMessageService;
import com.demo.springlearn.service.MomoSingService;
import com.demo.springlearn.service.OilMessageService;
import com.demo.springlearn.service.impl.FullBodyMessageServiceImpl;
import com.demo.springlearn.service.impl.MomoSingServiceImpl;
import com.demo.springlearn.service.impl.OilMessageServiceImpl;

public class Application {

    public static void main(String[] args) {

        IocContainer iocContainer=new IocContainer();
        // 存入bean
        iocContainer.beanDefinition("fullBodyService", FullBodyMessageServiceImpl.class);
        iocContainer.beanDefinition("momoSingService", MomoSingServiceImpl.class);
        iocContainer.beanDefinition("oilMessageService", OilMessageServiceImpl.class);
        // 存入aspect
        iocContainer.setAspect(new Aspect(new TimeCsAdvice(),new JoinPoint("com\\.demo\\.springlearn\\.service\\.impl\\..*MessageServiceImpl",".*Message")));

        // 获取bean
        FullBodyMessageService fullBodyMessageService = (FullBodyMessageService) iocContainer.getBean("fullBodyService");
        OilMessageService oilMessageService = (OilMessageService) iocContainer.getBean("oilMessageService");
        MomoSingService momoSingService = (MomoSingService) iocContainer.getBean("momoSingService");

        // 执行
        fullBodyMessageService.doMessage("mike");
        fullBodyMessageService.doBigMessage("mike");
        oilMessageService.doMessage("mike");
        momoSingService.sing("mike");
    }
}
