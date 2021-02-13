package com.codehuan.service.impl;

import com.codehuan.pojo.Blog;
import com.codehuan.mapper.BlogMapper;
import com.codehuan.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
