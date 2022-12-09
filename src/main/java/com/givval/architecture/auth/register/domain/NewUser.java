package com.givval.architecture.auth.register.domain;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;

@Data
public class NewUser {
  @JMap
  String name;
  @JMap
  String email;
  @JMap
  String password;
}
