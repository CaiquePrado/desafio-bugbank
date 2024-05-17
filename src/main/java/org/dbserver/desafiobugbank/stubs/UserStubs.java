package org.dbserver.desafiobugbank.stubs;

import java.util.Locale;

import org.dbserver.desafiobugbank.models.User;

import net.datafaker.Faker;

public class UserStubs {

  private static Faker faker = new Faker(new Locale("pt-BR"));
  private static User user;

  public static User validUserStub() {
    if (user == null) {
      user = User.builder()
          .name(faker.name().fullName())
          .email(faker.internet().emailAddress())
          .password(faker.internet().password())
          .build();
    }
    return user;
  }

  public static User invalidEmailUserStub() {
    return User.builder()
        .name(faker.name().fullName())
        .email("emailinvalido@com")
        .password(faker.internet().password())
        .build();
  }

  public static User mismatchPasswordUserStub() {
    return User.builder()
        .name(faker.name().fullName())
        .email(faker.internet().emailAddress())
        .password("password123")
        .build();
  }
}
