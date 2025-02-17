package com.charge.ev.entries;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Component
@Entity
public class Feedback {

	@Id
    @Column
 	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "fid_gen")
 	@SequenceGenerator(name = "fid_gen",initialValue = 1,allocationSize = 1,sequenceName = "fidgen")
 	private long feedbackid;
	
	@Column(nullable = false)
    private String feedbacktext;
	
	@Column(nullable = false)
    private int rating;
	
	@Column(updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(nullable = false)
    private String userId; 
	
	@Column(nullable = false)
	private long stationID;
	
	@Column(nullable = false, name = "SLOT_BOKING_ID")
	private long rid;

	public long getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(long feedbackid) {
		this.feedbackid = feedbackid;
	}


	public String getFeedbacktext() {
		return feedbacktext;
	}

	public void setFeedbacktext(String feedbacktext) {
		this.feedbacktext = feedbacktext;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getStationID() {
		return stationID;
	}

	public void setStationID(long stationID) {
		this.stationID = stationID;
	}

	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackid=" + feedbackid + ", FEEDBACK_TEXT=" + feedbacktext + ", RATING=" + rating
				+ ", createdAt=" + createdAt + ", userId=" + userId + ", stationID=" + stationID + ", rid=" + rid + "]";
	}
}
