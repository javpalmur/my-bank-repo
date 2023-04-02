package com.javpm.mybank.infrastructure.apirest.mappers;

import com.javpm.mybank.application.commands.RegisterUserCommand;
import com.javpm.mybank.domain.model.User;
import com.javpm.mybank.infraastructure.apirest.model.UserRequestV1DTO;
import com.javpm.mybank.infraastructure.apirest.model.UserV1DTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserV1DTOMapper {

  RegisterUserCommand asSaveUserCommand(UserRequestV1DTO src);

  UserV1DTO asUserV1DTO(User user);
}
