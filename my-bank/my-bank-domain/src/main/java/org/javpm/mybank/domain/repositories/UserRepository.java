package org.javpm.mybank.domain.repositories;

import org.javpm.mybank.domain.model.User;
import reactor.core.publisher.Mono;

public interface UserRepository {

  Mono<User> save(User user);

  Mono<User> findById(Integer userId);
}
