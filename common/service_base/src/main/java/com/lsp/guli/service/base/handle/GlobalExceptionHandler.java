package com.lsp.guli.service.base.handle;


import com.lsp.guli.common.base.result.R;
import com.lsp.guli.common.base.result.ResultCodeEnum;
import com.lsp.guli.common.base.util.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常统一处理,进行日志输出 配合ExceptionUtil工具类使用,控制异常的信息输出,
 * @author lsp
 * @since 2020/4/1
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
//        e.printStackTrace();
        log.error(ExceptionUtils.getMessage(e));
        return R.error();
    }

    /**
     * 此处往下 皆是对常用异常进行处理当产生异常 的时候,进入此类,找不到对应的异常,则会找他的父类也就是Exception,
     * 可以自己根据情况自定义
     * @param e
     * @return
     */
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e){
        log.error(ExceptionUtils.getMessage(e));
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R error(HttpMessageNotReadableException e){
        log.error(ExceptionUtils.getMessage(e));
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }
}
