package com.cadcli.test_compasso.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String exception) {
        super(exception);
    }
}
