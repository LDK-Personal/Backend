package com.ldkspringbase.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ldkspringbase.entity.UserEntity;

@Mapper
public interface UserMapper {
	boolean createUser(UserEntity userEntity);
	UserEntity login(UserEntity userEntity);
}
