package com.vn.ntd.amountroom.entity;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {


  USER(Collections.emptySet()), ADMIN(
      Set.of("admin:read", "admin:update", "admin:delete", "admin:create", "management:read",
          "management:update", "management:delete", "management:create")), MANAGER(
              Set.of("management:update", "management:delete", "management:create"))

  ;

  @Getter
  private final Set<String> permissions;

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions().stream()
        .map(permission -> new SimpleGrantedAuthority(permission)).collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
}
