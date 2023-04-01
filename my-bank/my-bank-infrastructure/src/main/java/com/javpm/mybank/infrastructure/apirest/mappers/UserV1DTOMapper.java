package com.javpm.mybank.infrastructure.apirest.mappers;

import com.javpm.mybank.domain.User;
import com.javpm.mybank.infraastructure.apirest.model.UserRequestV1DTO;
import com.javpm.mybank.application.commands.SaveUserCommand;
import com.javpm.mybank.infraastructure.apirest.model.UserV1DTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserV1DTOMapper {

  SaveUserCommand asSaveUserCommand(UserRequestV1DTO src);

  UserV1DTO asUserV1DTO(User user);
}
