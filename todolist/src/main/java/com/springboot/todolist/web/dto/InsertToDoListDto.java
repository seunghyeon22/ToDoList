package com.springboot.todolist.web.dto;

import com.springboot.todolist.domain.ToDoList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InsertToDoListDto {
	private String content;
	
	public ToDoList ToDoListEntity() {
		return ToDoList.builder()
				.content(content)
				.build();
	}
}
