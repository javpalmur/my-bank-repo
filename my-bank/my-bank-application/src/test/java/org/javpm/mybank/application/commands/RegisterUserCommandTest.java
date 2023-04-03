package org.javpm.mybank.application.commands;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import org.javpm.mybank.application.mappers.RegisterUserCommandMapperImpl;
import org.javpm.mybank.domain.model.User;
import org.javpm.mybank.domain.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class RegisterUserCommandTest {

  private static final String EMAIL = "email@email.com";

  private static final String NAME = "name";

  private static final String LAST_NAME = "lastName";

  private static final String PASSWORD = "password";

  @Mock
  private UserRepository userRepository;

  @Spy
  private RegisterUserCommandMapperImpl commandMapper;

  private RegisterUserCommandHandler registerUserCommandHandler;

  @BeforeEach
  void setUp() {
    this.registerUserCommandHandler = new RegisterUserCommandHandler(userRepository, commandMapper);
  }

  @Test
  void shouldRegisterUserSuccessfully() {
    // Arrange
    final RegisterUserCommand registerUserCommand = getRegisterUserCommand();
    final User user = getUser();
    given(this.userRepository.save(commandMapper.asUser(registerUserCommand))).willReturn(Mono.just(user));

    // Act
    final Mono<User> result = this.registerUserCommandHandler.execute(registerUserCommand);

    // Assert
    StepVerifier.create(result).expectNext(user).verifyComplete();
  }

  @Test
  void expectErrorWhenUserAlreadyExists() {
    // Arrange
    final RegisterUserCommand registerUserCommand = getRegisterUserCommand();

    // Act
    final Mono<User> result = this.registerUserCommandHandler.execute(registerUserCommand);

    // Assert
    StepVerifier.create(result).verifyError();
  }

  private User getUser() {
    final User user = new User();
    user.setId(1);
    user.setEmail(EMAIL);
    user.setName(NAME);
    user.setLastName(LAST_NAME);
    user.setPassword(PASSWORD);
    return user;
  }

  private RegisterUserCommand getRegisterUserCommand() {
    return RegisterUserCommand.builder()
        .email(EMAIL)
        .name(NAME)
        .lastName(LAST_NAME)
        .password(PASSWORD)
        .build();
  }
}
