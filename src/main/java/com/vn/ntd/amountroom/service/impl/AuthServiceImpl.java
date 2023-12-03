package com.vn.ntd.amountroom.service.impl;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vn.ntd.amountroom.dto.auth.AuthResDto;
import com.vn.ntd.amountroom.dto.auth.LoginReqDto;
import com.vn.ntd.amountroom.repo.UserRepo;
import com.vn.ntd.amountroom.service.AuthService;
import com.vn.ntd.amountroom.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final AuthenticationManager authenticationManager;
  private final UserRepo userRepo;
  private final JwtUtil jwtUtil;

  @Override
  public AuthResDto login(LoginReqDto dto) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
    var user = userRepo.findByUserName(dto.getUsername()).orElseThrow();
    var jwtToken = jwtUtil.generateToken(user);
    var refreshToken = jwtUtil.generateRefreshToken(user);
    return AuthResDto.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
  }

  @Override
  public void refreshToken(HttpServletRequest request, HttpServletResponse response)
      throws StreamWriteException, DatabindException, IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    userEmail = jwtUtil.extractUsername(refreshToken);
    if (userEmail != null) {
      var user = userRepo.findByUserName(userEmail).orElseThrow();
      if (jwtUtil.validateToken(refreshToken, user)) {
        var accessToken = jwtUtil.generateToken(user);
        // revokeAllUserTokens(user);
        // saveUserToken(user, accessToken);
        var authResponse =
            AuthResDto.builder().accessToken(accessToken).refreshToken(refreshToken).build();
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }

}
