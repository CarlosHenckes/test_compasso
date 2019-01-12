package com.cadcli.test_compasso;

import com.cadcli.test_compasso.entity.City;
import com.cadcli.test_compasso.repository.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCompassoApplicationTests {

	@Autowired
	private CityRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void databaseConnectionTest(){
		City newCity = repository.save(new City(0L, "Test","ND"));
		City gotCity = repository.findById(newCity.getId()).get();
		assertNotNull(gotCity);
		assertEquals(newCity.getId(), gotCity.getId());
	}
}

