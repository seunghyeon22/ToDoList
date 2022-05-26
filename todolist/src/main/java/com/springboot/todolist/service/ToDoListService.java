package com.springboot.todolist.service;

import com.springboot.todolist.web.dto.InsertToDoListDto;

public interface ToDoListService {
	public int insertToDoList(InsertToDoListDto insertToDoListDto);
}
