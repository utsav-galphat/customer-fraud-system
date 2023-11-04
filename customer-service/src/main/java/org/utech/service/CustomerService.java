package org.utech.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.utech.dto.CustomerRegistrationRequest;
import org.utech.dto.FraudCheckResponse;
import org.utech.entity.Customer;
import org.utech.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .first_name(request.first_name())
                .last_name(request.last_name())
                .email(request.email()).build();
        customerRepository.saveAndFlush(customer);

//        check if fraud
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8082/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, customer.getId());

        assert fraudCheckResponse != null;
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
    }
}
