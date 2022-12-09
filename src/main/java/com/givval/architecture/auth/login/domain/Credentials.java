package com.givval.architecture.auth.login.domain;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Value;

@Value
public class Credentials {
  @JMap
  String email;
  @JMap
  String password;
}
