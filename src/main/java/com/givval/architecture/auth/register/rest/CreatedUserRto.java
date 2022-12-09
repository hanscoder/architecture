package com.givval.architecture.auth.register.rest;

import com.givval.architecture.core.validations.StringValidationsRegex;
import com.googlecode.jmapper.annotations.JMap;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreatedUserRto {
  @NotNull
  @NotBlank
  @JMap
  String name;

  @NotNull
  @NotBlank
  @Pattern(regexp = StringValidationsRegex.EMAIL, message = "Invalid email")
  @JMap
  String email;

  @NotNull
  @NotBlank
  @JMap
  LocalDateTime createDate;
}
