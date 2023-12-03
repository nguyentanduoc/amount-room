package com.vn.ntd.amountroom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vn.ntd.amountroom.entity.RoomEntity;

@Repository
public interface RoomRepo extends JpaRepository<RoomEntity, Long> {

}
