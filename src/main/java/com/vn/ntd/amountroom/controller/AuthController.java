package com.vn.ntd.amountroom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.vn.ntd.amountroom.anotation.ApiPrefixController;
import com.vn.ntd.amountroom.dto.auth.AuthResDto;
import com.vn.ntd.amountroom.dto.auth.LoginReqDto;
import com.vn.ntd.amountroom.service.AuthService;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@ApiPrefixController
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("auth/login")
  ResponseEntity<AuthResDto> login(@RequestBody LoginReqDto loginReqDto) {
    return ResponseEntity.ok(authService.login(loginReqDto));
  }

  @GetMapping("auth/info")
  void info(@AuthenticationPrincipal UserDetails userDetails) {
    System.out.println(userDetails);
  }

  @PostMapping("auth/refresh-token")
  public void refreshToken(HttpServletRequest request, HttpServletResponse response)
      throws IOException, StreamWriteException, DatabindException, java.io.IOException {
    authService.refreshToken(request, response);
  }
}
