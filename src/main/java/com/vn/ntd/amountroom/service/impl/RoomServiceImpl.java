package com.vn.ntd.amountroom.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.vn.ntd.amountroom.dto.room.SaveRoomReqDto;
import com.vn.ntd.amountroom.entity.RoomEntity;
import com.vn.ntd.amountroom.repo.RoomRepo;
import com.vn.ntd.amountroom.service.RoomService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

  private final RoomRepo roomRepo;

  private final ModelMapper mapper;

  @Override
  public void save(SaveRoomReqDto reqDto) {
    RoomEntity entity = mapper.map(reqDto, RoomEntity.class);
    roomRepo.save(entity);
  }

}
