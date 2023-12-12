package com.WorkStride.customer;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(ICustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.fisrtName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();
        //to do : check if email valide
        //to do : check if email taken
        //to do : store  customer in db
        customerRepository.save(customer);
    }
}
