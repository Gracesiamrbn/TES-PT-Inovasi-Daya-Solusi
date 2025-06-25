package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ViewDataLoader implements CommandLineRunner {

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private StatusRepository statusRepo;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules(); // untuk parsing LocalDateTime
        File file = new File("viewData (3).json"); // nama sesuai file kamu

        JsonNode root = mapper.readTree(file);

        // Insert status
        for (JsonNode s : root.get("status")) {
            Status status = new Status();
            status.setId(s.get("id").asInt());
            status.setName(s.get("name").asText());
            statusRepo.save(status);
        }

        // Insert transactions
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (JsonNode t : root.get("data")) {
            Transaction trx = new Transaction();
            trx.setId(t.get("id").asInt());
            trx.setProductID(t.get("productID").asText());
            trx.setProductName(t.get("productName").asText());
            trx.setAmount(t.get("amount").asText());
            trx.setCustomerName(t.get("customerName").asText());
            trx.setCreateBy(t.get("createBy").asText());
            trx.setTransactionDate(LocalDateTime.parse(t.get("transactionDate").asText(), formatter));
            trx.setCreateOn(LocalDateTime.parse(t.get("createOn").asText(), formatter));

            int statusId = t.get("status").asInt();
            Status status = statusRepo.findById(statusId).orElseThrow();
            trx.setStatus(status);

            transactionRepo.save(trx);
        }

        System.out.println("✅ Data viewData.json berhasil dimuat ke database.");
    }
}
