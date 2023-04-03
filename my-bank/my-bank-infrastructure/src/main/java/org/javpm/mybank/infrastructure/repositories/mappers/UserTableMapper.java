package org.javpm.mybank.infrastructure.repositories.mappers;

import org.javpm.mybank.domain.model.User;
import org.javpm.mybank.infrastructure.repositories.tables.UserTable;
import org.mapstruct.Mapper;

@Mapper
public interface UserTableMapper {

  User asUser(UserTable userTable);

  UserTable asUserTable(User user);
}
