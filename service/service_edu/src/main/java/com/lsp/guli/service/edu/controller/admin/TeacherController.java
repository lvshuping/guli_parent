package com.lsp.guli.service.edu.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lsp.guli.common.base.result.R;
import com.lsp.guli.service.edu.entity.Teacher;
import com.lsp.guli.service.edu.entity.vo.TeacherVo;
import com.lsp.guli.service.edu.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/edu/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @ApiOperation(value = "查询讲师集合",notes = "查询所有讲师的集合")
    @GetMapping("/listAll")
    public R listAll(){
        List<Teacher> list = teacherService.list();
        PageHelper.startPage(1,5);
        PageInfo<Teacher> page = new PageInfo<Teacher>(list);
        return  R.ok().data("items",page);
    }

    @ApiOperation(value = "根据ID删除讲师", notes = "根据ID删除讲师，逻辑删除")
    @DeleteMapping("remove/{id}")
    public R removeById(@ApiParam(value = "讲师ID",required = true) @PathVariable String id){
        boolean b = teacherService.removeById(id);
        if(b){
            return R.ok().message("删除成功!");
        }
        return R.error().message("改数据不存在!");
    }

    @ApiOperation(value = "添加讲师",notes = "添加")
    @PostMapping("/add")
    public R add(@RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        if(save){
            return R.ok().message("添加成功!");
        }
        return R.error().message("添加失败!");
    }

    @ApiOperation(value = "根据Id获取讲师的详细信息")
    @PostMapping("get/{id}")
    public R getById(@ApiParam("讲师对象") @PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        if(null != teacher){
            return R.ok().data("item",teacher);
        }
        return R.error().message("没有该讲师!");
    }

    @ApiOperation(value = "修改讲师的信息",notes = "修改讲师的信息")
    @PostMapping("update")
    public R update(@ApiParam("讲师对象") @RequestBody Teacher teacher){
        boolean b = teacherService.updateById(teacher);
        if(b){
            return R.ok().message("修改成功!");
        }
        return R.error().message("修改失败!");
    }

    @ApiOperation(value = "分页查询",notes = "分页查询")
    @GetMapping("list/{page}/{size}")
    public R getByPage(@ApiParam (value = "当前页码",required = true)@PathVariable Integer page,
                       @ApiParam (value = "每页显示条数",required = true)@PathVariable Integer size,
                       @ApiParam TeacherVo teacherVo){
        Page page1 = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<Teacher>(page, size);
        IPage iPage = teacherService.selectPage(page1, teacherVo);
        List list = iPage.getRecords();
        long total = iPage.getTotal();
        return R.ok().data("items",list).data("total",total);
    }
}
