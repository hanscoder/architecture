package com.givval.architecture.auth.login.rest;

import lombok.Value;

@Value(staticConstructor = "of")
public class LoginResultRto {
  boolean status;
}
