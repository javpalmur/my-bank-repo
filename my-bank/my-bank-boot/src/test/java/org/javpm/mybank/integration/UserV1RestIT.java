package org.javpm.mybank.integration;

import org.javpm.mybank.infrastructure.apirest.model.UserRequestV1DTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@AutoConfigureWebTestClient(timeout = "300000")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserV1RestIT {

  private static final String BASE_PATH = "/v1/users";

  @Autowired
  private WebTestClient webClient;

  @Test
  void registerUser() {
    // Arrange
    final UserRequestV1DTO userRequestV1DTO = new UserRequestV1DTO()
        .name("USER_NAME")
        .email("email@email.com")
        .lastName("LAST_NAME")
        .password("PASSWORD");

    // Act
    final WebTestClient.ResponseSpec response = this.webClient.post()
        .uri(BASE_PATH)
        .body(Mono.just(userRequestV1DTO), UserRequestV1DTO.class)
        .accept(MediaType.APPLICATION_JSON)
        .exchange();

    // Assert
    response.expectStatus().isCreated();
  }
}
