package com.vn.ntd.amountroom.service.impl;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.vn.ntd.amountroom.entity.UserEntity;
import com.vn.ntd.amountroom.repo.UserRepo;
import com.vn.ntd.amountroom.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepo userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) {
    Optional<UserEntity> user = userRepo.findByUserName(username);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException("User not found: " + username);
    }
    return new User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
  }

  @Override
  public void saveUser(UserEntity user) {
    // TODO Auto-generated method stub

  }

}
