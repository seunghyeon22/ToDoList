package com.springboot.todolist.web.dto;

import com.springboot.todolist.domain.ToDoList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateToDoListReqDto {
	private String content;
	
	public ToDoList updateToDoListEntity(int id) {
		return ToDoList.builder()
				.id(id)
				.content(content)
				.build();
	}

}
