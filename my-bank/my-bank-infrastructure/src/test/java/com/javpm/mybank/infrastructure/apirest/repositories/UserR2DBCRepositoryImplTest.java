package com.javpm.mybank.infrastructure.apirest.repositories;

import static org.mockito.BDDMockito.given;

import com.javpm.mybank.domain.model.User;
import com.javpm.mybank.infrastructure.repositories.UserR2DBCRepositoryImpl;
import com.javpm.mybank.infrastructure.repositories.UserR2DBCRepositoryImpl.UserH2Repository;
import com.javpm.mybank.infrastructure.repositories.mappers.UserDBMapperImpl;
import com.javpm.mybank.infrastructure.repositories.model.UserDB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class UserR2DBCRepositoryImplTest {

  private static final String EMAIL = "email@email.com";

  private static final String NAME = "name";

  private static final String LAST_NAME = "lastName";

  private static final String PASSWORD = "password";

  private static final Integer USER_ID = 1;

  @Mock
  private UserH2Repository repository;

  @Spy
  private UserDBMapperImpl userDBMapper;

  private UserR2DBCRepositoryImpl userR2DBCRepository;

  @BeforeEach
  void setUp() {
    userR2DBCRepository = new UserR2DBCRepositoryImpl(repository, userDBMapper);
  }

  @Test
  void shouldSaveUser() {
    // Arrange
    final User user = getUser();
    final UserDB userDB = userDBMapper.asUserDB(user);
    given(this.repository.save(userDB)).willReturn(Mono.just(userDB));

    // Act
    Mono<User> result = userR2DBCRepository.save(user);

    // Assert
    StepVerifier.create(result).expectNext(user).verifyComplete();
  }

  @Test
  void shouldFindUserById() {
    // Arrange
    final User user = getUser();
    final UserDB userDB = userDBMapper.asUserDB(user);
    given(this.repository.findById(USER_ID)).willReturn(Mono.just(userDB));

    // Act
    Mono<User> result = userR2DBCRepository.findById(USER_ID);

    // Assert
    StepVerifier.create(result).expectNext(user).verifyComplete();
  }

  @Test
  void expectErrorWhenUserDoesntExist() {
    // Arrange
    given(this.repository.findById(USER_ID)).willReturn(Mono.empty());

    // Act
    Mono<User> result = userR2DBCRepository.findById(USER_ID);

    // Assert
    StepVerifier.create(result).verifyError();
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
