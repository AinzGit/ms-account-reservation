package com.ainzgit.accountreservation.config;

import com.ainzgit.accountreservation.entity.AccountStatus;
import com.ainzgit.accountreservation.repository.AccountStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountStatusInitializer implements CommandLineRunner {

    private final AccountStatusRepository accountStatusRepository;

    public AccountStatusInitializer(AccountStatusRepository accountStatusRepository) {
        this.accountStatusRepository = accountStatusRepository;
    }

    @Override
    public void run(String... args) {
        createStatusIfNotExists("NEW", "Счёт создан в БД");
        createStatusIfNotExists("IN_CREATION", "Запрос на создание счета был отправлен в смежную систему");
        createStatusIfNotExists("CREATED", "Счёт создан в смежной системе");
        createStatusIfNotExists("CANCELLED", "Счёт аннулирован");
        createStatusIfNotExists("CLOSED", "Счёт закрыт");
    }

    private void createStatusIfNotExists(String name, String description) {
        if (accountStatusRepository.findByName(name).isEmpty()) {
            AccountStatus status = new AccountStatus();
            status.setName(name);
            status.setDescription(description);
            accountStatusRepository.save(status);
        }
    }
}