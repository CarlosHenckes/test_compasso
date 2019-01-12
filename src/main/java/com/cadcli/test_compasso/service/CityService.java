package com.cadcli.test_compasso.service;

import com.cadcli.test_compasso.entity.City;
import com.cadcli.test_compasso.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public void inserirCity(City city){
        repository.save(city);
    }

    public List<City> pesquisarPorCidade(String cidade){
        return repository.findByCityNameContainingIgnoreCase(cidade);
    }

    public List<City> cidadesPorEstado(String uf){
        return repository.findByStateIgnoreCase(uf);
    }
}
