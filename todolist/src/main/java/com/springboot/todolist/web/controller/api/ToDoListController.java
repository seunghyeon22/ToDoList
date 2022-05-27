package com.springboot.todolist.web.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todolist.domain.ToDoList;
import com.springboot.todolist.service.ToDoListService;
import com.springboot.todolist.web.dto.InsertToDoListDto;
import com.springboot.todolist.web.dto.ToDoListRespDto;
import com.springboot.todolist.web.dto.UpdateToDoListReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ToDoListController {
	
	private final ToDoListService toDoListService;
	
	
	//리스트 전체 들고오기
	@GetMapping("/todo/all")
	public ResponseEntity<?> getList(){
		List<ToDoList> doLists = toDoListService.getToDoList();
		return new ResponseEntity<>(doLists,HttpStatus.OK);
	}
	//내용 추가
	@PostMapping("/todo")
	public ResponseEntity<?> addToDo(@Valid @RequestBody InsertToDoListDto insertToDoListDto){
		int result = toDoListService.insertToDoList(insertToDoListDto);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	//내용 수정
	@PutMapping("/todo/{id}")
	public ResponseEntity<?> modifiToDo(@PathVariable int id, @Valid @RequestBody UpdateToDoListReqDto updateToDoListReqDto){
		int result = toDoListService.updateToDoList(id, updateToDoListReqDto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	//내용 삭제
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<?> removeToDo(@PathVariable int id){
		int result = toDoListService.deleteToDoList(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
