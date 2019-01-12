package com.cadcli.test_compasso.controller;

import com.cadcli.test_compasso.entity.Customer;
import com.cadcli.test_compasso.exceptions.CustomerNotFoundException;
import com.cadcli.test_compasso.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@Api(description = "Operações de gerenciamento de clientes")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    @ApiOperation(value = "Inserir um novo cliente")
    public ResponseEntity<String> insertCustomer(@RequestBody Customer customer){
        service.inserirCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body("Novo cliente criado");
    }

    @GetMapping(path="/{id}")
    @ApiOperation(value = "Pesquisar cliente por seu ID")
    public ResponseEntity pesquisarCliente(@PathVariable("id") Long id) {
            Optional customer = service.pesquisarClientePorId(id);
            if(!customer.isPresent()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente #"+ id +" não encontrado");
            }
            return ResponseEntity.ok().body(customer);
    }

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Pesquisar cliente por nome", response = List.class)
    public List<Customer> pesquisarClientePorNome(@RequestParam("nome") String nome){
        return service.pesquisarClientePorNome(nome);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Excluir um cliente por seu ID")
    public ResponseEntity<String> excluirCliente(@PathVariable("id") Long id){
        service.excluirCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído");
    }

    @PutMapping
    @ApiOperation(value = "Atualizar dados do cliente")
    public ResponseEntity atualizarCliente(@RequestBody Customer customer){
        service.atualizarCliente(customer);
        return ResponseEntity.status(HttpStatus.OK).body("Informações atualizadas");
    }
}
