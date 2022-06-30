package com.example.transactions;

import com.example.transactions.model.Account;
import com.example.transactions.repository.AccountRepo;
import com.example.transactions.service.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransactionsApplicationTests {

    @Test
    @DisplayName("happy flow without exceptions")
    void happyFlow() {
        AccountRepo accountRepo = mock(AccountRepo.class);
        TransferService transferService = new TransferService(accountRepo);

        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(5500));

        Account destination = new Account();
        destination.setId(2);
        destination.setAmount(new BigDecimal(1000));

        when(accountRepo.findAccountById(sender.getId())).thenReturn(sender);
        when(accountRepo.findAccountById(destination.getId())).thenReturn(destination);

        transferService.transferMoney(sender.getId(), destination.getId(), new BigDecimal(500));


    }

}
