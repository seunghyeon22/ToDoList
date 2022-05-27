package com.springboot.todolist.service;

import java.util.List;

import com.springboot.todolist.domain.ToDoList;
import com.springboot.todolist.web.dto.InsertToDoListDto;
import com.springboot.todolist.web.dto.ToDoListRespDto;
import com.springboot.todolist.web.dto.UpdateToDoListReqDto;

public interface ToDoListService {
	public int insertToDoList(InsertToDoListDto insertToDoListDto);
	public int updateToDoList(int id, UpdateToDoListReqDto updateToDoListReqDto);
	public int deleteToDoList(int id);
	public List<ToDoList> getToDoList();
}
