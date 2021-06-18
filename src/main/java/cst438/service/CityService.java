package cst438.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cst438.domain.*;
 
@Service
public class CityService {
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private WeatherService weatherService;
	
	public CityService( ) { }
	
	public CityInfo getCityInfo(String cityName) {
		List<City> cityList = cityRepository.findByName(cityName);
		
		if (cityList.size() <= 0) {
			return null;
		}
		
		City city = cityList.get(0);
		
		TempAndTime tempAndTime = weatherService.getTempAndTime(cityName);
		
		return new CityInfo(city, tempAndTime);
	}
	
}
