package com.charge.ev.entries;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "slot_booking")
public class Reservation {
	@Id
    @Column
 	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Rid_gen")
 	@SequenceGenerator(name = "Rid_gen",initialValue = 1,allocationSize = 1,sequenceName = "Ridgen")
 	private long rid;
	
	@Column(nullable = false)
    private String evbrand;
	
	@Column(nullable = false)
    private String vendorid;
	
	@Column(nullable = false)
	private long stationID;
	
	@Column(nullable = false)
    private String slotType;
    
	@Column(nullable = false)
    private String evmodel;
	
	@Column(nullable = false)
    private double batterystatus;
	
	@Column(nullable = false)
    private double batteryCapacity;
	
	@Column(nullable = false)
    private String sdatet;
	
	@Column(nullable = false)
    private String edatet;
	
	@Column(nullable = false)
    private String paymentType;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String userId;
    
    
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
	}

	public String getEVbrand() {
		return evbrand;
	}

	public void setEVbrand(String eVbrand) {
		evbrand = eVbrand;
	}

	public String getVendorid() {
		return vendorid;
	}

	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}

	public String getSlotType() {
		return slotType;
	}

	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}

	public String getEVmodel() {
		return evmodel;
	}

	public void setEVmodel(String eVmodel) {
		evmodel = eVmodel;
	}

	public double getBatterystatus() {
		return batterystatus;
	}

	public void setBatterystatus(double batterystatus) {
		this.batterystatus = batterystatus;
	}

	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getSdatet() {
		return sdatet;
	}

	public void setSdatet(String sdatet) {
		this.sdatet = sdatet;
	}

	public String getEdatet() {
		return edatet;
	}

	public void setEdatet(String edatet) {
		this.edatet = edatet;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getStationID() {
		return stationID;
	}

	public void setStationID(long stationID) {
		this.stationID = stationID;
	}

	@Override
	public String toString() {
		return "Reservation [rid=" + rid + ", EVbrand=" + evbrand + ", vendorid=" + vendorid + ", stationID="
				+ stationID + ", slotType=" + slotType + ", EVmodel=" + evmodel + ", batterystatus=" + batterystatus
				+ ", batteryCapacity=" + batteryCapacity + ", sdatet=" + sdatet + ", edatet=" + edatet
				+ ", paymentType=" + paymentType + ", status=" + status + "]";
	}   
    
    }
