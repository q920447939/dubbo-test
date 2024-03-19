/**
 * @Project:
 * @Author:
 * @Date: 2024年03月19日
 */
package com.example.dubboconsumer;

import com.example.dubboapi.Api;
import com.example.dubboapi.UserQuery;
import com.example.dubboapi.UserResponse;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;


@Service
public class Init implements ApplicationRunner {
    @DubboReference
    private Api api;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserResponse userResponse = api.queryUser(new UserQuery());
        System.out.println(userResponse);
    }
}
