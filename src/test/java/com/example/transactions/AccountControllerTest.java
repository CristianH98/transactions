package com.example.transactions;

import com.example.transactions.controller.AccountController;
import com.example.transactions.model.Account;
import com.example.transactions.model.TransferRequest;
import com.example.transactions.service.TransferService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TransferService transferService;

    @InjectMocks
    private AccountController accountController;

    ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        transferService = mock(TransferService.class);
        accountController = mock(AccountController.class);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

    }

    @Test
    public void it_should_get_accounts() throws Exception {
        Account cristi = new Account();
        cristi.setId(1);
        cristi.setName("Cristi");
        cristi.setAmount(new BigDecimal(100));

        List<Account> accountList = new ArrayList<>();
        accountList.add(cristi);

        when(transferService.getAllAccounts()).thenReturn(accountList);

        mockMvc.perform(MockMvcRequestBuilders.get("/accounts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void it_should_transfer() throws Exception {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setAmount(new BigDecimal(100));
        transferRequest.setReceiverId(1);
        transferRequest.setSenderId(2);

        transferService.transferMoney(2,1, new BigDecimal(100));

        mockMvc.perform(MockMvcRequestBuilders.post("/transfer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transferRequest)))
                        .andExpect(status().isOk())
                        .andReturn();

    }

}
