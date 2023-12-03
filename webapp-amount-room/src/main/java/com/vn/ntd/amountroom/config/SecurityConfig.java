package com.vn.ntd.amountroom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.vn.ntd.amountroom.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private static final String[] WHITE_LIST_URL =
      {"/api/auth/login", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
          "/configuration/security", "/swagger-ui/**", "/webjars/**", "/swagger-ui.html"};

  @Autowired
  private AuthenticationProvider authenticationProvider;

  @Autowired
  private JwtAuthenticationFilter authenticationFilter;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf((csrf) -> csrf.disable())
        .authorizeHttpRequests((authz) -> authz.requestMatchers(WHITE_LIST_URL).permitAll()
            .anyRequest().authenticated())
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
    // .logout(logout ->
    // logout.logoutUrl("/api/v1/auth/logout")
    // .addLogoutHandler(logoutHandler)
    // .logoutSuccessHandler((request, response, authentication) ->
    // SecurityContextHolder.clearContext())
    return http.build();
  }

}
