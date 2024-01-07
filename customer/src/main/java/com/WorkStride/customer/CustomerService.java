package com.WorkStride.customer;
import com.WorkStride.clients.fraud.FraudCheckReponse;
import com.WorkStride.clients.fraud.FraudClient;
import com.WorkStride.clients.notification.NotificationClient;
import com.WorkStride.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final ICustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
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
        FraudCheckReponse fraudCheckReponse =
                  fraudClient.isFraudster(customer.getId());
        if(fraudCheckReponse.isFraudCheck()) {
            throw new IllegalStateException("fraudster");
        }
        notificationClient.sendNotfication(new NotificationRequest(customer.getId(),
                                                                   customer.getEmail(),
                                                                    String.format("Hi %s, welcom abdelkalek",
                                                                            customer.getFirstName())));


    }
}
