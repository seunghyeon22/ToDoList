package com.springboot.todolist.domain;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToDoListRepository {
	public int insertToDoList(ToDoList toDoList);
}
