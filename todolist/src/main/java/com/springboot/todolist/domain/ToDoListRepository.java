package com.springboot.todolist.domain;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToDoListRepository {
	public int insertToDoList(ToDoList toDoList);
	public int updateToDoList(ToDoList toDoList);
	public int deleteToDoList(int id);
	public List<ToDoList> getToDoList();
	
}
