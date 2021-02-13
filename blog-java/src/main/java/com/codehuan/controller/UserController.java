package com.codehuan.controller;


import com.codehuan.common.lang.Result;
import com.codehuan.pojo.User;
import com.codehuan.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author codehuan
 * @since 2021-02-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Object index() {
        User user = userService.getById(1L);
        return Result.success(user);
    }

    @PostMapping("/save")
    public Object save(@Validated @RequestBody User user) {

        return Result.success(user);
    }

}
