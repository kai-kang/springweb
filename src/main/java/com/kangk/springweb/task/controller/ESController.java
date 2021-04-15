package com.kangk.springweb.task.controller;

import java.util.Date;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kangk.springweb.task.elasticsearch.ESMapper;
import com.kangk.springweb.task.entity.EsMem;
import com.kangk.springweb.task.uitl.pageQuery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(tags = "ES测试",description = "ESController")
@RestController
@RequestMapping("/es")
public class ESController {
    @Autowired
    private ESMapper esMapper;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    //添加文档
    @PostMapping("/addesMem")
    @ApiOperation("添加文档")
    public EsMem  addEsMem(){
    	EsMem esMem =new EsMem();
    	String id = new Date().getTime()+"";
    	esMem.setId(id);
    	esMem.setName("测试数据"+id);
        return esMapper.save(esMem);
    }
 
    //查询文档
    @PostMapping("/find")
    @ApiOperation("查询文档")
    public Iterable<EsMem>  findMember(){
    	return esMapper.findAll();
    			
        //return esMapper.findById(id);
    }
 
    //查询文档
    /*@PostMapping("/findAll")
    @ApiOperation("查询所有文档")
    public void   findAllEsMem(){
        Iterable<EsMem> age = esMapper.findAll(Sort.by("six").ascending()); //查询所有根据six正序 排序
        Page<EsMem> all = esMapper.findAll(Pageable.unpaged());
        long totalElements = all.getTotalElements(); //总条数
        int totalPages = all.getTotalPages();    //总页数
        Stream<EsMem> memberStream = all.get();
        System.out.println(totalElements + "   "+totalPages +"   " +memberStream.toString());
        Iterator<EsMem> iterator = age.iterator();
        while (iterator.hasNext()){
        	EsMem next = iterator.next();
            System.out.println(next);
        }
    }*/
 
    //简单自定义查询  ES约定俗称方法名自定义查询
    /*@PostMapping("/findBySix")
    @ApiOperation("自定义查询<初级版>")
    public  List<EsMem> findBySix(){
        List<EsMem> bySixBetween = esMapper.findBySixBetween(5, 10); //查询six 在5到10之间
        System.out.println("bySixBetween   "+bySixBetween);
        System.out.println();
        List<EsMem> bySix = esMapper.findBySixBetweenOrderBySixDesc(5, 10); //查询six 在5到10之间 按six倒序
        System.out.println("bySix    "+bySix);
        System.out.println();
        List<EsMem> nameLike = esMapper.findByNameLike("天上人间1");  //根据name模糊查询
        System.out.println("nameLike    "+nameLike);
        return bySixBetween;
    }*/
 
    //删除文档
    @PostMapping("/delete")
    @ApiOperation("删除文档")
    public void deleteMember(String id){
        boolean b = esMapper.existsById(id);
        esMapper.deleteById(id);
        System.out.println(b);
    }
 
    @PostMapping("/pageSelect")
    @ApiOperation("自定义查询 <高级版>")
    public void selectCustom(@RequestBody pageQuery query){
    //public void selectCustom(String str){
        // 构建查询条件
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        String name = query.getName();
        MatchQueryBuilder buider = new MatchQueryBuilder("name", name);
        nativeSearchQueryBuilder.withQuery(buider);
        int page = query.getPage()-1;
        int size = query.getLimit();
        nativeSearchQueryBuilder.withPageable(PageRequest.of(page,size));
        // 搜索，获取结果
        System.out.println(nativeSearchQueryBuilder.build().toString());
        SearchHits<EsMem> search = elasticsearchRestTemplate.search(nativeSearchQueryBuilder.build(),EsMem.class);
        // 总条数
        long total = search.getTotalHits();
        System.out.println("总条数 = " + total);
    }
}
