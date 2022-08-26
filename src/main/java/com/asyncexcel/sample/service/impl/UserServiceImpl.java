package com.asyncexcel.sample.service.impl;

import com.asyncexcel.sample.entity.User;
import com.asyncexcel.sample.mapper.UserMapper;
import com.asyncexcel.sample.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 姚仲杰
 * @since 2022-08-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
