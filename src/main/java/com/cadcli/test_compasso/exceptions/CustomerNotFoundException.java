package com.cadcli.test_compasso.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Nenhum cliente encontrado para o ID: " + id);
    }
}
