package com.example.dubboconsumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication(scanBasePackages = "com.example.dubboconsumer")
@EnableDubbo(scanBasePackages = "com.example.dubboconsumer")
public class DubboConsumerApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DubboConsumerApplication.class, args);
        new CountDownLatch(1).await();
    }

}
