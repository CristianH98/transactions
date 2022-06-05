package com.example.transactions.controller;

import com.example.transactions.service.TransferService;
import com.example.transactions.model.Account;
import com.example.transactions.model.TransferRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest){
        transferService.transferMoney(transferRequest.getSenderId(),
                transferRequest.getReceiverId(), transferRequest.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(){
        return transferService.getAllAccounts();
    }
}
