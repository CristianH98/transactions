package com.example.transactions.service;

import com.example.transactions.model.Account;
import com.example.transactions.repository.AccountRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TransferService {
    private final AccountRepo accountRepo;

    public TransferService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public void transferMoney(long idSender, long idReceiver, BigDecimal amount){
        Account sender = accountRepo.findAccountById(idSender);
        Account receiver = accountRepo.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepo.changeAmount(idSender, senderNewAmount);
        accountRepo.changeAmount(idReceiver, receiverNewAmount);
    }

    public List<Account> getAllAccounts(){
        return accountRepo.findAllAcounts();
    }

}
