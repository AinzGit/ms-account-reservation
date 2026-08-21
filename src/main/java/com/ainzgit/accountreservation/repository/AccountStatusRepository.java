package com.ainzgit.accountreservation.repository;

import com.ainzgit.accountreservation.entity.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountStatusRepository extends JpaRepository<AccountStatus, Integer> {

    Optional<AccountStatus> findByName(String name);
}