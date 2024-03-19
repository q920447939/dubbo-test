
package com.example.dubboprovider;

import com.example.dubboapi.Api;
import com.example.dubboapi.UserQuery;
import com.example.dubboapi.UserResponse;
import org.apache.dubbo.config.annotation.DubboService;


@DubboService(validation = "true")
public class ApiServerImpl implements Api {
    @Override
    public UserResponse queryUser(UserQuery userQuery) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(userQuery.getName());
        return userResponse;
    }
}
