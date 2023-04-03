package org.javpm.mybank.infrastructure.repositories;

import org.javpm.mybank.domain.exceptions.NotFoundException;
import org.javpm.mybank.domain.model.User;
import org.javpm.mybank.domain.repositories.UserRepository;
import org.javpm.mybank.infrastructure.repositories.mappers.UserTableMapper;
import org.javpm.mybank.infrastructure.repositories.tables.UserTable;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class UserR2DBCRepositoryImpl implements UserRepository {

  private UserH2Repository repository;

  private UserTableMapper userTableMapper;

  @Override
  public Mono<User> save(User user) {
    return Mono.just(user)
        .map(userTableMapper::asUserTable)
        .flatMap(this.repository::save)
        .map(userTableMapper::asUser);
  }

  @Override
  public Mono<User> findById(Integer userId) {
    return Mono.just(userId)
        .flatMap(this.repository::findById)
        .switchIfEmpty(Mono.defer(() -> Mono.error(new NotFoundException(String.format("User with id %s not found", userId)))))
        .map(userTableMapper::asUser);
  }

  @Repository
  public interface UserH2Repository extends R2dbcRepository<UserTable, Integer> {
  }
}
