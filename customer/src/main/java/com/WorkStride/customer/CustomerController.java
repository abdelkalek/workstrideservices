package com.WorkStride.customer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;
    @PostMapping
    public void registerCustormer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new Customer regisrtaion {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }


}
