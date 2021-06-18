package cst438.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cst438.domain.City;
import cst438.domain.CityInfo;
import cst438.domain.CityRepository;
import cst438.domain.Country;
import cst438.domain.CountryRepository;
import cst438.domain.TempAndTime;

@SpringBootTest
public class CityServiceTest {	
   @MockBean
   private CityRepository cityRepository;
   @MockBean
   private CountryRepository countryRepository;
   @MockBean
   private WeatherService weatherService;
   @Autowired
   private CityService cityService;
   
   @Test
   public void testMultipleCities() throws Exception {
      // Set up temp and time
      double temp = 0.0;
      long time = 0;
      int timezone = 0;
      TempAndTime tempAndTime = new TempAndTime(temp, time, timezone);
      
      int cityId = 0;
      String cityName = "Chicago";
      String district = "some district";
      int population = 10000;
      Country country = new Country("US", "United States");
      City city = new City(cityId, cityName, district, population, country);
      
      List<City> cityList = new ArrayList<City>();
      cityList.add(city);
      cityList.add(city);
      
      given(cityRepository.findByName(cityName)).willReturn(cityList);
      given(countryRepository.findByCode(country.getCode())).willReturn(country);
      given(weatherService.getTempAndTime(cityName)).willReturn(tempAndTime);
      
      CityInfo expectedCityInfo = new CityInfo(city, tempAndTime);
      
      CityInfo actualCityInfo = cityService.getCityInfo(cityName);
      
      assertThat(actualCityInfo).isEqualTo(expectedCityInfo);
   }
   
   @Test
   public void testOneCity() throws Exception {
      // Set up temp and time
      double temp = 0.0;
      long time = 0;
      int timezone = 0;
      TempAndTime tempAndTime = new TempAndTime(temp, time, timezone);
      
      int cityId = 0;
      String cityName = "Chicago";
      String district = "some district";
      int population = 10000;
      Country country = new Country("US", "United States");
      City city = new City(cityId, cityName, district, population, country);
      
      List<City> cityList = new ArrayList<City>();
      cityList.add(city);
      
      given(cityRepository.findByName(cityName)).willReturn(cityList);
      given(countryRepository.findByCode(country.getCode())).willReturn(country);
      given(weatherService.getTempAndTime(cityName)).willReturn(tempAndTime);
      
      CityInfo expectedCityInfo = new CityInfo(city, tempAndTime);
      
      CityInfo actualCityInfo = cityService.getCityInfo(cityName);
      
      assertThat(actualCityInfo).isEqualTo(expectedCityInfo);
   }
   
   @Test
   public void testZeroCities() throws Exception {
      // Set up temp and time
      double temp = 0.0;
      long time = 0;
      int timezone = 0;
      TempAndTime tempAndTime = new TempAndTime(temp, time, timezone);
      TempAndTime nullTempAndTime = null;
      
      int cityId = 0;
      String cityName = "Chicago";
      String district = "some district";
      int population = 10000;
      Country country = new Country("US", "United States");
      City city = new City(cityId, cityName, district, population, country);
      City nullCity = new City();
      
      List<City> cityList = new ArrayList<City>();
      
      given(cityRepository.findByName(cityName)).willReturn(cityList);
      given(countryRepository.findByCode(country.getCode())).willReturn(country);
      given(weatherService.getTempAndTime(cityName)).willReturn(tempAndTime);
      
      CityInfo expectedCityInfo = null;
      
      CityInfo actualCityInfo = cityService.getCityInfo(cityName);
      
      assertThat(actualCityInfo).isEqualTo(expectedCityInfo);
   }
}
