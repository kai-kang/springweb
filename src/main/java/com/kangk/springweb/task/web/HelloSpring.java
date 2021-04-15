package com.kangk.springweb.task.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kangk.springweb.task.elasticsearch.ESMapper;
import com.kangk.springweb.task.entity.EsMem;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/test")
public class HelloSpring {
	/*@ResponseBody*/
	@Autowired
    private ESMapper esMapper;
	@RequestMapping("/hello")
	public String hello()
	{
		return "index";
	}
	@PostMapping("/addesMem")
    @ApiOperation("添加文档")
    public EsMem  addEsMem(@RequestBody EsMem esMem){
    	String id = new Date().getTime()+"";
    	esMem.setId(id);
    	esMem.setName("测试数据"+id);
        return esMapper.save(esMem);
    }
}
