package com.cadcli.test_compasso.controller;

import com.cadcli.test_compasso.entity.City;
import com.cadcli.test_compasso.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@Api(description = "Operações de gerenciamento de dados de cidades")
public class CityController {

    @Autowired
    private CityService service;

    @PostMapping
    @ApiOperation(value = "Cria uma nova cidade")
    public ResponseEntity<String> insertCity(@RequestBody City city){
        service.inserirCity(city);
        return ResponseEntity.status(HttpStatus.OK).body("Nova cidade criada");
    }

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Pesquisa cidade por nome", response = List.class)
    public List<City> pesquisarCidade(@RequestParam("cidade") String cidade){
        return service.pesquisarPorCidade(cidade);
    }

    @GetMapping(produces = "application/json", path = "/list")
    @ApiOperation(value = "Retorna uma lista de cidades para o estado pesquisado", response = List.class)
    public List<City> cidadesPorEstado(@RequestParam("uf") String uf){
        return service.cidadesPorEstado(uf);
    }
}
