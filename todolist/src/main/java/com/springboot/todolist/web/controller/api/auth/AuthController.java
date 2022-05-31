package com.springboot.todolist.web.controller.api.auth;

import javax.naming.Binding;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todolist.annotation.aop.Validation;
import com.springboot.todolist.service.auth.AuthService;
import com.springboot.todolist.web.dto.CMRespDto;
import com.springboot.todolist.web.dto.auth.SignupReqDto;
import com.springboot.todolist.web.dto.auth.UsernameCheckReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	private final AuthService authService;
	
	@Validation
	@GetMapping("/signup/username")
	public ResponseEntity<?> checkUsername(@Valid UsernameCheckReqDto usernameCheckReqDto, BindingResult bindingResult)throws Exception{
		System.out.println(usernameCheckReqDto);
		return new ResponseEntity<>(new CMRespDto<Boolean>(1,"username ok", authService.checkUsername(usernameCheckReqDto.getUsername())), HttpStatus.OK);
	}
	
	@Validation
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupReqDto signupReqDto, BindingResult bindingResult) throws Exception{
		System.out.println(signupReqDto);
		
		return new ResponseEntity<>(new CMRespDto<Boolean>(1,"signup ok", authService.signup(signupReqDto)), HttpStatus.OK);
	}
}



