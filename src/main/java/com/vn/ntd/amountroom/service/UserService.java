package com.vn.ntd.amountroom.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.vn.ntd.amountroom.entity.UserEntity;

public interface UserService extends UserDetailsService {

  public UserDetails loadUserByUsername(String username);

  void saveUser(UserEntity user);
}
