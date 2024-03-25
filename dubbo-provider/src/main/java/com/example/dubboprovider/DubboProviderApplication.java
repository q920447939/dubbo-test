package com.example.dubboprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication(scanBasePackages = "com.example.dubboprovider")
@EnableDubbo(scanBasePackages = "com.example.dubboprovider")
public class DubboProviderApplication {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("dubbo.application.serialize-check-status","DISABLE");
        SpringApplication.run(DubboProviderApplication.class, args);
        new CountDownLatch(1).await();

    }

}
