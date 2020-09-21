package com.lsp.guli.service.edu.service.impl;

import com.lsp.guli.service.edu.entity.User;
import com.lsp.guli.service.edu.mapper.UserMapper;
import com.lsp.guli.service.edu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsp
 * @since 2020-09-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
