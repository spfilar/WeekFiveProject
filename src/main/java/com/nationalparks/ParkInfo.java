package com.nationalparks;

public class ParkInfo {

	private int parkID = 0;
	private String parkName = null;
	private String parkCity = null;
	private String parkState = null;
	private int parkYearEst = 0;
	private int parkFee = 0;
	
	public ParkInfo() {
		super();
	}

	public int getParkID() {
		return parkID;
	}

	public void setParkID(int parkID) {
		this.parkID = parkID;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkCity() {
		return parkCity;
	}

	public void setParkCity(String parkCity) {
		this.parkCity = parkCity;
	}

	public String getParkState() {
		return parkState;
	}

	public void setParkState(String parkState) {
		this.parkState = parkState;
	}

	public int getParkYearEst() {
		return parkYearEst;
	}

	public void setParkYearEst(int parkYearEst) {
		this.parkYearEst = parkYearEst;
	}

	public int getParkFee() {
		return parkFee;
	}

	public void setParkFee(int parkFee) {
		this.parkFee = parkFee;
	}
	
}
