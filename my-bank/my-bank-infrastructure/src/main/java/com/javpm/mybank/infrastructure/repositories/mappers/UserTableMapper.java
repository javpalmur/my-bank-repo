package com.javpm.mybank.infrastructure.repositories.mappers;

import com.javpm.mybank.domain.model.User;
import com.javpm.mybank.infrastructure.repositories.tables.UserTable;
import org.mapstruct.Mapper;

@Mapper
public interface UserTableMapper {

  User asUser(UserTable userTable);

  UserTable asUserTable(User user);
}
