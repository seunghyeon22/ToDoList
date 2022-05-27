package com.springboot.todolist.web.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDoListRespDto {
	private int id;
	private int usercode;
	private String content;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
