package com.nice.app.dto;

public class HotelDTO {

	private Long hotelId;
	private String hotelName;
	private String area;
	private String hotelType;
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHotelType() {
		return hotelType;
	}
	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}
	public HotelDTO(Long hotelId, String hotelName, String area, String hotelType) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.area = area;
		this.hotelType = hotelType;
	}
	public HotelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
