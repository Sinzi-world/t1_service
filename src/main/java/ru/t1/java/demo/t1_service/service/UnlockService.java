package ru.t1.java.demo.t1_service.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.t1.java.demo.t1_service.entity.Account;
import ru.t1.java.demo.t1_service.entity.Client;
import ru.t1.java.demo.t1_service.repository.AccountRepository;
import ru.t1.java.demo.t1_service.repository.ClientRepository;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@Data
public class UnlockService {

    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public UnlockService(ClientRepository clientRepository, AccountRepository accountRepository) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
    }

    public String unlockClient(UUID clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            Random random = new Random();
            // Рандомизированное решение для разблокировки
            boolean decision = random.nextBoolean();
            client.setBlocked(!decision);
            clientRepository.save(client);
            return decision ? "Client unlocked" : "Client remains blocked";
        } else {
            return "Client not found";
        }
    }

    public String unlockAccount(UUID accountId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            Random random = new Random();
            // Рандомизированное решение для снятия ареста с счета
            boolean decision = random.nextBoolean();
            account.setFrozen(!decision);
            accountRepository.save(account);
            return decision ? "Account unlocked" : "Account remains frozen";
        } else {
            return "Account not found";
        }
    }
}

