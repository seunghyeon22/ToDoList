package com.springboot.todolist.service.auth;

import org.springframework.stereotype.Service;

import com.springboot.todolist.domain.auth.UserRepository;
import com.springboot.todolist.web.dto.auth.SignupReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
	
	@Override
	public boolean checkUsername(String username) throws Exception {
		return userRepository.findUserByUsername(username)==null;
	}
	
	@Override
	public boolean signup(SignupReqDto signupReqDto) throws Exception{
		return userRepository.save(signupReqDto.toEntity())>0;
	}
}
