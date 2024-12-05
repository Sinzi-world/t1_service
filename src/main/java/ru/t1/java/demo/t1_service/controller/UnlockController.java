package ru.t1.java.demo.t1_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.t1.java.demo.t1_service.service.UnlockService;

import java.util.UUID;

@RestController
@RequestMapping("/unlock")
public class UnlockController {

    private final UnlockService unlockService;

    @Autowired
    public UnlockController(UnlockService unlockService) {
        this.unlockService = unlockService;
    }

    @PostMapping("/client/{clientId}")
    public String unlockClient(@PathVariable UUID clientId) {
        return unlockService.unlockClient(clientId);
    }

    @PostMapping("/account/{accountId}")
    public String unlockAccount(@PathVariable UUID accountId) {
        return unlockService.unlockAccount(accountId);
    }
}
