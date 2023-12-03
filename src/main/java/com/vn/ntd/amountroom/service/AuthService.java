package com.vn.ntd.amountroom.service;

import java.io.IOException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.vn.ntd.amountroom.dto.auth.AuthResDto;
import com.vn.ntd.amountroom.dto.auth.LoginReqDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

  AuthResDto login(LoginReqDto dto);

  void refreshToken(HttpServletRequest request, HttpServletResponse response)
      throws StreamWriteException, DatabindException, IOException;
}
