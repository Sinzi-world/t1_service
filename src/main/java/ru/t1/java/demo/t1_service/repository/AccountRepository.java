package ru.t1.java.demo.t1_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.t1.java.demo.t1_service.entity.Account;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

}