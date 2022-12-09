package com.givval.architecture.auth.login.persistence;

import com.givval.architecture.core.persistence.CoreEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User extends CoreEntity {

  @Column(nullable = false)
  String name;
  @Column(nullable = false, unique = true)
  String email;
  @Column(nullable = false)
  String password;
}
