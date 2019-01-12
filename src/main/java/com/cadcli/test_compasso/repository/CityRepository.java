package com.cadcli.test_compasso.repository;

import com.cadcli.test_compasso.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findByCityNameContainingIgnoreCase(String query);
    List<City> findByStateIgnoreCase(String state);
}
