package com.givval.architecture.auth.login.rest;

import static com.givval.architecture.core.mapper.MagicMapper.mapperOf;

import com.givval.architecture.auth.login.domain.Credentials;
import com.givval.architecture.auth.login.domain.LoginService;
import com.givval.architecture.core.mapper.MagicMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth")
@RestController()
@RequiredArgsConstructor
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

  private final MagicMapper<Credentials, CredentialsRto> mapper = mapperOf(Credentials.class, CredentialsRto.class);
  private final LoginService loginService;
  @PostMapping("login")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<LoginResultRto> login(@Valid @RequestBody CredentialsRto credentials) {
    try {
      loginService.login(mapper.map(credentials));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(LoginResultRto.of(false));
    }
    return ResponseEntity.ok(LoginResultRto.of(true));
  }
}
