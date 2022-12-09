package com.givval.architecture.auth.login.domain;

import com.givval.architecture.auth.login.persistence.User;
import com.givval.architecture.auth.login.persistence.UserRepository;
import com.givval.architecture.core.domain.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

  private final UserRepository userRepository;

  @UseCase
  public void login(Credentials credentials) {
    userRepository.findByEmail(credentials.getEmail())
      .filter(user -> isEquals(credentials, user))
      .orElseThrow(() -> new RuntimeException("Credentials are wrong"));
  }

  private static boolean isEquals(Credentials credentials, User user) {
    return user.getPassword().equals(credentials.getPassword());
  }
}
