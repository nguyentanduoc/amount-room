package com.vn.ntd.amountroom.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditingEntity {

  @CreatedDate
  @Column(nullable = false, updatable = false)
  private LocalDateTime createAt;

  @CreatedBy
  @Column(nullable = false, updatable = false)
  private Long createBy;

  @LastModifiedDate
  @Column(insertable = false)
  private LocalDateTime updateAt;

  @LastModifiedBy
  @Column(insertable = false)
  private Long updateBy;
}
