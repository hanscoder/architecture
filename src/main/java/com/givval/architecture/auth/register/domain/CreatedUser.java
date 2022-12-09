package com.givval.architecture.auth.register.domain;

import com.googlecode.jmapper.annotations.JMap;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CreatedUser {
  @JMap
  String name;
  @JMap
  String email;
  @JMap
  LocalDateTime createDate;
}
