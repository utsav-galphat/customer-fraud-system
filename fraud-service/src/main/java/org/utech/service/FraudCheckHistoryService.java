package org.utech.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.utech.repository.FraudCheckHistoryRepository;
import org.utech.entity.FraudCheckHistory;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
