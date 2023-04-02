package com.javpm.mybank.application.mappers;

import com.javpm.mybank.application.commands.RegisterUserCommand;
import com.javpm.mybank.domain.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface RegisterUserCommandMapper {

  User asUser(RegisterUserCommand command);
}
