package com.ldkspringbase.service;

import org.springframework.stereotype.Service;

import com.ldkspringbase.entity.UserEntity;
import com.ldkspringbase.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;

	public boolean createUser(UserEntity userEntity) {
		return userMapper.createUser(userEntity);
	}

	public boolean login(UserEntity userEntity) {
		return userMapper.login(userEntity) != null;
	}

}
