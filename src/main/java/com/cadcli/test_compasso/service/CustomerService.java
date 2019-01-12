package com.cadcli.test_compasso.service;

import com.cadcli.test_compasso.entity.Customer;
import com.cadcli.test_compasso.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public void inserirCustomer(Customer customer){
        repository.save(customer);
    }

    public List<Customer> pesquisarClientePorNome(String nome) {
        return repository.findByNameContainingIgnoreCaseOrderByNameAsc(nome);
    }

    public Optional<Customer> pesquisarClientePorId(Long id) {
        return repository.findById(id);
    }

    public void excluirCliente(Long id){
        repository.deleteById(id);
    }

    public void atualizarCliente(Customer customer){
        repository.save(customer);
    }
}
