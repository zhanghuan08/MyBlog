package com.codehuan.service.impl;

import com.codehuan.pojo.User;
import com.codehuan.mapper.UserMapper;
import com.codehuan.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author codehuan
 * @since 2021-02-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
