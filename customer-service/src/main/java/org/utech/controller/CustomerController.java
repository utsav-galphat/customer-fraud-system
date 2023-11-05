package org.utech.controller;

import lombok.AllArgsConstructor;
import org.utech.dto.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.utech.service.CustomerService;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/healthcheck")
    public String healthCheck(){
        return "I am UP and Running!";
    }

    @PostMapping("/")
    public void createCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("new customer registration {}" , customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
