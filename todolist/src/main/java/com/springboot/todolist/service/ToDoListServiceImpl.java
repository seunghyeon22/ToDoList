package com.springboot.todolist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.todolist.domain.ToDoList;
import com.springboot.todolist.domain.ToDoListRepository;
import com.springboot.todolist.web.dto.InsertToDoListDto;
import com.springboot.todolist.web.dto.ToDoListRespDto;
import com.springboot.todolist.web.dto.UpdateToDoListReqDto;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ToDoListServiceImpl implements ToDoListService {
	
	private final ToDoListRepository toDoListRepository;

	@Override
	public int insertToDoList(InsertToDoListDto insertToDoListDto) {
		ToDoList toDoList = insertToDoListDto.ToDoListEntity();
		int result = toDoListRepository.insertToDoList(toDoList);
		return 0;
	}
	@Override
	public int updateToDoList(int id, UpdateToDoListReqDto updateToDoListReqDto) {
		// TODO Auto-generated method stub
		ToDoList toDoList = updateToDoListReqDto.updateToDoListEntity(id);
		int result = toDoListRepository.updateToDoList(toDoList);
		return 0;
	}
	@Override
	public int deleteToDoList(int id) {
		int result = toDoListRepository.deleteToDoList(id);
		return 0;
	}
	
	@Override
	public List<ToDoList> getToDoList() {
		List<ToDoList> todoList = toDoListRepository.getToDoList();
		return todoList;
	}
}
