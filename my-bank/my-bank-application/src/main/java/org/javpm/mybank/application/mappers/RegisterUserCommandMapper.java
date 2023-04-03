package org.javpm.mybank.application.mappers;

import org.javpm.mybank.application.commands.RegisterUserCommand;
import org.javpm.mybank.domain.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface RegisterUserCommandMapper {

  User asUser(RegisterUserCommand command);
}
