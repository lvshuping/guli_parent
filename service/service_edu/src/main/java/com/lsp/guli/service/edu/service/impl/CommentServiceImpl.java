package com.lsp.guli.service.edu.service.impl;

import com.lsp.guli.service.edu.entity.Comment;
import com.lsp.guli.service.edu.mapper.CommentMapper;
import com.lsp.guli.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author lsp
 * @since 2020-09-21
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
