package com.example.transactions;

import com.example.transactions.model.Account;
import com.example.transactions.repository.AccountRepo;
import com.example.transactions.service.TransferService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TransferServiceTest {
    AccountRepo accountRepo;
    TransferService transferService;
    List<Account> accounts;
    Account account;

    @Before
    public void setUp() throws Exception {
        accounts = new ArrayList<>();
        account = new Account();
        accounts.add(account);
        accountRepo = mock(AccountRepo.class);
        transferService = new TransferService(accountRepo);
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