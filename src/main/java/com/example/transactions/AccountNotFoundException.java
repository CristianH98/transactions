package com.example.transactions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("No account found");
    }
}
