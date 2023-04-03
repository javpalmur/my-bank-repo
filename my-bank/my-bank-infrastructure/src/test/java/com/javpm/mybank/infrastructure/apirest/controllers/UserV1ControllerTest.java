package com.javpm.mybank.infrastructure.apirest.controllers;

import static org.mockito.BDDMockito.given;

import java.net.URI;

import com.javpm.mybank.application.commands.RegisterUserCommandHandler;
import com.javpm.mybank.domain.model.User;
import com.javpm.mybank.infraastructure.apirest.model.UserRequestV1DTO;
import com.javpm.mybank.infrastructure.apirest.mappers.UserV1DTOMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class UserV1ControllerTest {

  private static final String EMAIL = "email@email.com";

  private static final String NAME = "name";

  private static final String LAST_NAME = "lastName";

  private static final String PASSWORD = "password";

  private static final Integer USER_ID = 1;

  @Spy
  private UserV1DTOMapperImpl userV1DTOMapper;

  @Mock
  private RegisterUserCommandHandler registerUserCommandHandler;

  @Mock
  private ServerWebExchange serverWebExchange;

  @Mock
  private ServerHttpRequest serverHttpRequest;

  private UserV1Controller userV1Controller;

  @BeforeEach
  void setUp() {
    userV1Controller = new UserV1Controller(registerUserCommandHandler, userV1DTOMapper);
  }

  @Test
  void shouldRegisterUser() {
    // Arrange
    UserRequestV1DTO userRequestV1DTO = new UserRequestV1DTO().email(EMAIL).name(NAME).lastName(LAST_NAME).password(PASSWORD);
    given(this.registerUserCommandHandler.execute(userV1DTOMapper.asSaveUserCommand(userRequestV1DTO))).willReturn(Mono.just(getUser()));
    given(this.serverWebExchange.getRequest()).willReturn(this.serverHttpRequest);

    // Act
    Mono<ResponseEntity<Void>> response = userV1Controller.registerUser(Mono.just(userRequestV1DTO), serverWebExchange);

    // Assert
    StepVerifier.create(response).expectNext(ResponseEntity.created(URI.create(serverWebExchange.getRequest().getURI() + "/" + USER_ID)).build()).verifyComplete();
  }

  private User getUser() {
    final User user = new User();
    user.setId(USER_ID);
    user.setEmail(EMAIL);
    user.setName(NAME);
    user.setLastName(LAST_NAME);
    user.setPassword(PASSWORD);
    return user;
  }
}
