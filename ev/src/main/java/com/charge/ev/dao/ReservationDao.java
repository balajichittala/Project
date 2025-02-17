package com.charge.ev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charge.ev.entries.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Long>{

	@Query(value="select * from slot_booking where vendorid=?1 and to_char(sdatet,'YYYY-MM-DD')=?2", nativeQuery = true)
	public List<Reservation> getByVendorIdandDate(String vendorid,String availability);

	public List<Reservation> findByUserId(String userId);
	public List<Reservation> findByVendorid(String vendorid);
	public List<Reservation> findByStationID(long stationid);
	
	 @Transactional
	 @Modifying
	 @Query(value="update slot_booking set status=?1 where rid=?2" , nativeQuery = true)
	 public void updateStatus(String status,long rid);
}
