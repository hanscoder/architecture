package com.givval.architecture.auth.register.domain;

import static com.givval.architecture.core.mapper.MagicMapper.mapperOf;

import com.givval.architecture.auth.login.persistence.User;
import com.givval.architecture.auth.login.persistence.UserRepository;
import com.givval.architecture.core.mapper.MagicMapper;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

  private final MagicMapper<CreatedUser, User> mapper = mapperOf(CreatedUser.class, User.class);
  private final UserRepository userRepository;

  public CreatedUser registerUser(NewUser newUser) {
    if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
      throw new RuntimeException("Register is not possible. Dont try it again");
    }

    var user = new User();
    user.setName(newUser.getName());
    user.setEmail(newUser.getEmail());
    user.setPassword(newUser.getPassword());
    user.setCreateDate(LocalDateTime.now());

    return mapper.map(userRepository.save(user));
  }
}
