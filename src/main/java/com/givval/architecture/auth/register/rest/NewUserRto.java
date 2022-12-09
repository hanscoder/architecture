package com.givval.architecture.auth.register.rest;

import com.givval.architecture.core.validations.StringValidationsRegex;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Value;

@Value
public class NewUserRto {

  @NotNull
  @NotBlank
  String name;

  @NotNull
  @NotBlank
  @Pattern(regexp = StringValidationsRegex.EMAIL, message = "Invalid email")
  String email;
  @NotNull
  @NotBlank
  String password;

}
