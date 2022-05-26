package com.springboot.todolist.service;

import org.springframework.stereotype.Service;

import com.springboot.todolist.domain.ToDoList;
import com.springboot.todolist.domain.ToDoListRepository;
import com.springboot.todolist.web.dto.InsertToDoListDto;

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
}
