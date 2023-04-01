package com.javpm.mybank.application.mappers;

import com.javpm.mybank.application.commands.SaveUserCommand;
import com.javpm.mybank.domain.User;
import org.mapstruct.Mapper;

@Mapper
public interface SaveUserCommandMapper {

  User asUser(SaveUserCommand command);
}
