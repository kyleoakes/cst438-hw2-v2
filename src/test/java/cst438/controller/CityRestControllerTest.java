package cst438.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import cst438.domain.City;
import cst438.domain.CityInfo;
import cst438.domain.Country;
import cst438.domain.TempAndTime;
import cst438.service.CityService;

@WebMvcTest
public class CityRestControllerTest {
   
   @MockBean
   private CityService cityService;
   @Autowired
   MockMvc mvc;
   
   JacksonTester<CityInfo> json;
   
   @Test
   public void test1() throws Exception {
      double temp = 296.83;
      long time = 1623107366;
      int timezone = -18000;
      TempAndTime tempAndTime = new TempAndTime(temp, time, timezone);
      
      int cityId = 3795;
      String cityName = "Chicago";
      String district = "Illinois";
      int population = 2896016;
      
      Country country = new Country("USA", "United States");
      City city = new City(cityId, cityName, district, population, country);
      CityInfo cityInfo = new CityInfo(city, tempAndTime);
      given(cityService.getCityInfo(cityName)).willReturn(cityInfo);
      
      CityInfo expected = new CityInfo();
      
      MockHttpServletResponse response = mvc.perform(get("/api/cities/{city}").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response.getContentAsString()).isEqualTo(json.write(expected).getJson());

   }
}
