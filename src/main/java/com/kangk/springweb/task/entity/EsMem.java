package com.kangk.springweb.task.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName="es_test", type="mem")
public class EsMem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3802008421964142251L;
	@Id
	@Field(type=FieldType.Keyword,analyzer = "ik_max_word")
	private String id;
	
	@Field(type=FieldType.Keyword,analyzer = "ik_max_word")
	private String name;

}
