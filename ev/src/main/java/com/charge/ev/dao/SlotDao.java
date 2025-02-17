package com.charge.ev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charge.ev.entries.SlotType;
import com.charge.ev.entries.VendorDetails;

@Repository
public interface SlotDao extends JpaRepository<SlotType, Integer>{
	
@Transactional
@Modifying
//@Query(value = "delete from slot_type where stationid = ?1", nativeQuery = true)
public int deleteByStationID(VendorDetails stationid);
	
}
