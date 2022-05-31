package com.springboot.todolist.domain.auth;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	public User findUserByUsername(String username) throws Exception;
	public int save(User user) throws Exception;

}
