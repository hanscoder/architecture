package com.givval.architecture.auth.register.rest;

import static com.givval.architecture.core.mapper.MagicMapper.mapperOf;

import com.givval.architecture.auth.register.domain.CreatedUser;
import com.givval.architecture.auth.register.domain.NewUser;
import com.givval.architecture.auth.register.domain.RegisterService;
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
public class RegisterController {

  private final MagicMapper<NewUser, NewUserRto> toDomain = mapperOf(NewUser.class, NewUserRto.class);
  private final MagicMapper<CreatedUserRto, CreatedUser> toRto = mapperOf(CreatedUserRto.class, CreatedUser.class);

  private final RegisterService registerService;

  @PostMapping("register")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<CreatedUserRto> register(@Valid @RequestBody NewUserRto newUser) {
    var result = registerService.registerUser(toDomain.map(newUser));
    return ResponseEntity.ok(toRto.map(result));
  }
}
