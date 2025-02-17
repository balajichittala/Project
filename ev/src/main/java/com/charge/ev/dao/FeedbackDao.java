package com.charge.ev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charge.ev.entries.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback, Long> {
	
	public List<Feedback> findByStationID(long stationID);

}
