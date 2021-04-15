package com.kangk.springweb.task.elasticsearch;


import org.springframework.data.repository.CrudRepository;

import com.kangk.springweb.task.entity.EsMem;

public interface ESMapper extends CrudRepository<EsMem, String> {


}
