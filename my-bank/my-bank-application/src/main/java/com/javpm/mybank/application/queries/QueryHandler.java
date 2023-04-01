package com.javpm.mybank.application.queries;

import reactor.core.CorePublisher;

public interface QueryHandler<T, E> {

  E execute(T query);
}
