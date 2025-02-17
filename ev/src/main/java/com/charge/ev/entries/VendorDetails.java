package com.charge.ev.entries;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vd")
public class VendorDetails {

	 	@Id
	    @Column
	 	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Sid_gen")
	 	@SequenceGenerator(name = "Sid_gen",initialValue = 1,allocationSize = 1,sequenceName = "Sdgen")
	 	private long stationID;
	 	
	 	@Column
	 	private String vendorid;
	 	
	    @Column(nullable = false)
	    private String vendorName;

		@Column(nullable = false)
	    private String stationName;

	    @Column(nullable = false)
	    private int pincode;
	    
	    @Column(nullable = false)
	    private String city;
	    
	    @Column(nullable = false)
	    private String landmark;
	    
	    @Column(nullable = false)
	    private String state;
	    
	    @Column(nullable = false)
	    private int slot;
	    
	    @Column(nullable = false)
	    private String capacity;
	    
	    @Column(nullable = false)
	    private int vType;
	    
	    @Column(updatable = false)
	    private LocalDateTime createdAt = LocalDateTime.now();
	    
	    @Column( nullable = false)
	    private long phone; 
	    
	    @Column( nullable = false)
	    private String email;
	    
	    @Column(nullable = false)
	    private double latitude;

	    @Column(nullable = false)
	    private double longitude;

	    @OneToMany(mappedBy = "stationID", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    public List<SlotType> sl;
	    
	    public List<SlotType> getSl() {
			return sl;
		}

		public void setSl(List<SlotType> sl) {
			this.sl = sl;
		}

		public long getstationID() {
			return stationID;
		}

		public void setstationID(long stationID) {
			this.stationID = stationID;
		}
		public String getVendorid() {
			return vendorid;
		}
		
		//@PrePersist
		public void setVendorid(String vendorid) {
			this.vendorid = vendorid;
		}
		
	    public String getVendorName() {
			return vendorName;
		}

		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}

		public String getStationName() {
			return stationName;
		}

		public void setStationName(String stationName) {
			this.stationName = stationName;
		}

		public int getPincode() {
			return pincode;
		}

		public void setPincode(int pincode) {
			this.pincode = pincode;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getLandmark() {
			return landmark;
		}

		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public int getSlot() {
			return slot;
		}

		public void setSlot(int slot) {
			this.slot = slot;
		}

		public String getCapacity() {
			return capacity;
		}

		public void setCapacity(String capacity) {
			this.capacity = capacity;
		}

		public int getvType() {
			return vType;
		}

		public void setvType(int vType) {
			this.vType = vType;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public long getPhone() {
			return phone;
		}

		public void setPhone(long phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		public double getLatitude() {
		    return latitude;
		}

		public void setLatitude(double latitude) {
		    this.latitude = latitude;
		}

		public double getLongitude() {
		    return longitude;
		}

		public void setLongitude(double longitude) {
		    this.longitude = longitude;
		}

		@Override
		public String toString() {
			return "VendorDetails [stationID=" + stationID + ", vendorid=" + vendorid + ", vendorName=" + vendorName
					+ ", stationName=" + stationName + ", pincode=" + pincode + ", city=" + city + ", landmark="
					+ landmark + ", state=" + state + ", slot=" + slot + ", capacity=" + capacity + ", vType=" + vType
					+ ", createdAt=" + createdAt + ", phone=" + phone + ", email=" + email + ", latitude=" + latitude
					+ ", longitude=" + longitude + "]";
		}
}
