package com.WorkStride.customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final ICustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.fisrtName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();
        //to do : check if email valide
        //to do : check if email taken
        //to do : store  customer in db
        // to do : check if Fraudster
        customerRepository.saveAndFlush(customer);
        FraudCheckReponse fraudCheckReponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}", FraudCheckReponse.class, customer.getId()
        );
        if(fraudCheckReponse.isFraudCheck()) {
            throw new IllegalStateException("fraudster");
        }

    }
}
