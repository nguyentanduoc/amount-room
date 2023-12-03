package com.vn.ntd.amountroom.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.vn.ntd.amountroom.anotation.ApiPrefixController;
import com.vn.ntd.amountroom.dto.room.SaveRoomReqDto;
import com.vn.ntd.amountroom.service.RoomService;
import lombok.RequiredArgsConstructor;

@RestController
@ApiPrefixController
@RequiredArgsConstructor
public class RoomController {

  private final RoomService roomService;


  @PostMapping("/room/add")
  void addRoom(@RequestBody SaveRoomReqDto saveRoomReqDto) {
    roomService.save(saveRoomReqDto);
  }
}
