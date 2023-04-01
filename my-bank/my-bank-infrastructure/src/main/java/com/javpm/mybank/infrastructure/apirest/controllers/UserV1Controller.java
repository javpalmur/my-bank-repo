package com.javpm.mybank.infrastructure.apirest.controllers;

import java.net.URI;

import com.javpm.mybank.infraastructure.apirest.apis.UserV1Api;
import com.javpm.mybank.infraastructure.apirest.model.UserRequestV1DTO;
import com.javpm.mybank.infrastructure.apirest.mappers.UserV1DTOMapper;
import com.javpm.mybank.application.commands.SaveCommandHandler;
import com.javpm.mybank.application.commands.SaveUserCommand;
import com.javpm.mybank.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class UserV1Controller implements UserV1Api {

  private final SaveCommandHandler<SaveUserCommand, User> saveUserCommandHandler;

  private final UserV1DTOMapper userV1DTOMapper;

  @Override
  public Mono<ResponseEntity<Void>> registerUser(Mono<UserRequestV1DTO> userRequestV1DTO, ServerWebExchange exchange) {
    return userRequestV1DTO
        .map(this.userV1DTOMapper::asSaveUserCommand)
        .flatMap(this.saveUserCommandHandler::execute)
        .map(this.userV1DTOMapper::asUserV1DTO)
        .map(userV1DTO -> ResponseEntity.created(URI.create(exchange.getRequest().getURI() + "/" + userV1DTO.getId())).build());
  }
}
