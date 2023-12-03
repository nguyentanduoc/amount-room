package com.vn.ntd.amountroom.entity;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RoomEntity extends AuditingEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_generator")
  @SequenceGenerator(name = "room_generator", sequenceName = "room_seq", allocationSize = 1)
  private Long id;

  private String name;

  private BigDecimal price;
}
