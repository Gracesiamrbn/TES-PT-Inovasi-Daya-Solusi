package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ApiController {

    private final TransactionRepository transactionRepo;
    private final StatusRepository statusRepo;

    public ApiController(TransactionRepository t, StatusRepository s) {
        this.transactionRepo = t;
        this.statusRepo = s;
    }

    @GetMapping("/data")
    public Map<String, Object> getData() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", transactionRepo.findAll());
        result.put("status", statusRepo.findAll());
        return result;
    }
}
