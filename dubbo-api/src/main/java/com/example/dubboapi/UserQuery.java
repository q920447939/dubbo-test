/**
 * @Project:
 * @Author:
 * @Date: 2024年03月19日
 */
package com.example.dubboapi;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserQuery implements Serializable {
    @NotNull(message = "姓名不能为空")
    private String name;

    @Min(value = 10,message = "年龄不能小于10")
    private Integer age;
}
