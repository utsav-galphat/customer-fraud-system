package org.utech.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.utech.dto.FraudCheckResponse;
import org.utech.service.FraudCheckHistoryService;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public record FraudCheckHistoryController(FraudCheckHistoryService fraudCheckHistoryService) {

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId){
        boolean isFraudCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        log.info("fraud check for customer {}" , customerId);
        return new FraudCheckResponse(isFraudCustomer);
    }

}
