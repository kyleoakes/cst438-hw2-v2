package cst438.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Id;

public class CityInfo {

	@Id
	int id;
	
	String cityName;
	String countryCode;
	String district;
	int population;
	String countryName;
	TempAndTime tempAndTime;
	
	public CityInfo( ) {
		System.out.println("CityInfo.CityInfo( ): blank constructor called.");
	}
	
	public CityInfo(int id, String name, String countryCode, String district, int population, String countryName) {
		this.id = id;
		this.cityName = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
		this.countryName = countryName;
	}
	
	public CityInfo(City city, TempAndTime tempAndTime) {
		if (city == null) { return; }
	   this.id = city.getId();
		this.cityName = city.getName();
		if (city.getCountry() == null) { 
		   this.countryCode = null; 
		} else {
		   this.countryCode = city.getCountry().getCode();
		}
		this.district = city.getDistrict();
		this.population = city.getPopulation();
		if (city.getCountry() == null) { 
		   this.countryCode = null; 
		} else {
		   this.countryName = city.getCountry().getName();
		}
		this.tempAndTime = tempAndTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityInfo other = (CityInfo) obj;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (id != other.id)
			return false;
		if (population != other.population)
			return false;
		if (tempAndTime == null) {
			if (other.tempAndTime != null)
				return false;
		} else if (!tempAndTime.equals(other.tempAndTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CityInfo [id=" + id + ", cityName=" + cityName + ", countryCode=" + countryCode + ", district="
				+ district + ", population=" + population + ", countryName=" + countryName + ", tempAndTime="
				+ tempAndTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public TempAndTime getTempAndTime() {
		return tempAndTime;
	}

	public void setTempAndTime(TempAndTime tempAndTime) {
		this.tempAndTime = tempAndTime;
	}

}
