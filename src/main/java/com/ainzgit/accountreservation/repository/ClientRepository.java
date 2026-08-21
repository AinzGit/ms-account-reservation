package com.ainzgit.accountreservation.repository;

import com.ainzgit.accountreservation.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}