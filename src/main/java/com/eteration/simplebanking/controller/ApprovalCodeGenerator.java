package com.eteration.simplebanking.controller;

import java.util.UUID;

public class ApprovalCodeGenerator {
    public String generateRandomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString();
    }
}
