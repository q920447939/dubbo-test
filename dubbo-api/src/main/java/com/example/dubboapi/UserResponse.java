/**
 * @Project:
 * @Author:
 * @Date: 2024年03月19日
 */
package com.example.dubboapi;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponse implements Serializable {
    private String name;
}
