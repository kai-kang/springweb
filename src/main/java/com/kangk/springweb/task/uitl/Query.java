package com.kangk.springweb.task.uitl;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Query implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1427731975181086304L;
	
	/** 当前页码 **/
	@ApiModelProperty(value = "当前页码", required = true)
	private Integer page;

	/** 分页大小 **/
	@ApiModelProperty(value = "分页大小", required = true)
	private Integer limit;

	/** 创建分页条件 **/
	public Pageable doCreatePageable() {
		if (Objects.isNull(page) || Objects.isNull(limit)) {
			System.out.println("分页条件不能为空");
			//throw new ServiceException("分页条件不能为空");
			return null;
		} else {
			return PageRequest.of(page, limit);
		}
	}

	/** 转换分页结果 **/
	public PageResult doConvert(List<pageQuery> list, long count, Pageable pageable) {
		return new PageResult(list, (int) count, pageable.getPageSize(), pageable.getPageNumber());
	}
}
