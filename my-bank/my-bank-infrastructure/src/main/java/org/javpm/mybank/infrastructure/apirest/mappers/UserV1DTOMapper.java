package org.javpm.mybank.infrastructure.apirest.mappers;

import org.javpm.mybank.application.commands.RegisterUserCommand;
import org.javpm.mybank.domain.model.User;
import org.javpm.mybank.infrastructure.apirest.model.UserRequestV1DTO;
import org.javpm.mybank.infrastructure.apirest.model.UserV1DTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserV1DTOMapper {

  RegisterUserCommand asSaveUserCommand(UserRequestV1DTO src);

  UserV1DTO asUserV1DTO(User user);
}
