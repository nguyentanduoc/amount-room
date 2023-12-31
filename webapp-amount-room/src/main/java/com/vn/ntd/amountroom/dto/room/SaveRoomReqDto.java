package com.vn.ntd.amountroom.dto.room;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveRoomReqDto {

  private String name;

  private BigDecimal price;
}
