package org.dbserver.desafiobugbank.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

  private String name;
  private String email;
  private String password;

}
