package com.javpm.mybank.application.queries;

public interface QueryHandler<T, E> {

  E execute(T query);
}
