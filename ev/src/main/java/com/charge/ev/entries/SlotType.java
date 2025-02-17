package com.charge.ev.entries;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="slot_type")
public class SlotType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	@ManyToOne
	@JoinColumn(name="stationID")
	@JsonBackReference
	private VendorDetails stationID;
	
	@Column
	private String slotType;
	
	public VendorDetails getstationID() {
		return stationID;
	}
	public void setstationID(VendorDetails stationID) {
		this.stationID = stationID;
	}
	public String getSlotType() {
		return slotType;
	}
	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}
	@Override
	public String toString() {
		return "SlotType [stationID=" + stationID + ", slotType="+slotType+"]";
	}
}
