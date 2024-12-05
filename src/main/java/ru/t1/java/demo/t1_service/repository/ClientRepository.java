package ru.t1.java.demo.t1_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.t1.java.demo.t1_service.entity.Client;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}