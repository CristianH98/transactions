package com.example.transactions;

import com.example.transactions.model.Account;
import com.example.transactions.repository.AccountRepo;
import com.example.transactions.service.TransferService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class TransferServiceTest {

    @Mock
    AccountRepo accountRepo;
    @InjectMocks
    TransferService transferService;
    List<Account> accounts;
    Account account;

    @Before
    public void setUp() {
        accounts = new ArrayList<>();
        account = new Account();
        accounts.add(account);
    }

    @Test
    public void transferMoney() {
    }

    @Test
    public void getAllAccounts() {
        when(accountRepo.findAllAcounts()).thenReturn(accounts);
        List<Account> accountList = transferService.getAllAccounts();
        assertEquals(accounts, accountList);
        verify(accountRepo, times(1)).findAllAcounts();

    }
}