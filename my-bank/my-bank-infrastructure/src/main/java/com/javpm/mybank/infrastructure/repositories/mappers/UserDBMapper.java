package com.javpm.mybank.infrastructure.repositories.mappers;

import com.javpm.mybank.domain.model.User;
import com.javpm.mybank.infrastructure.repositories.model.UserDB;
import org.mapstruct.Mapper;

@Mapper
public interface UserDBMapper {

  User asUser(UserDB userDB);

  UserDB asUserDB(User user);
}
