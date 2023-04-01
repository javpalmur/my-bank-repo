package com.javpm.mybank.infrastructure.repositories;

import com.javpm.mybank.domain.User;
import com.javpm.mybank.domain.repositories.UserRepository;
import com.javpm.mybank.infrastructure.repositories.mappers.UserDBMapper;
import com.javpm.mybank.infrastructure.repositories.model.UserDB;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class UserR2DBCRepositoryImpl implements UserRepository {

  private UserH2Repository repository;

  private UserDBMapper userDBMapper;

  @Override
  public Mono<User> save(User user) {
    return Mono.just(user)
        .map(userDBMapper::asUserDB)
        .flatMap(this.repository::save)
        .map(userDBMapper::asUser);
  }

  @Repository
  public interface UserH2Repository extends R2dbcRepository<UserDB, Integer> {
  }
}
