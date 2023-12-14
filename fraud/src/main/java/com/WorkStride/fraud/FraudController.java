package com.WorkStride.fraud;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private final FraudServices fraudServices;

    @PostMapping(path="{customerId")
    public FraudCheckReponse isFraudster(@PathVariable("customerId") Integer customerId) {
    boolean isFraudCheck =  fraudServices.isFraudulentCustomer(customerId);
    return  new FraudCheckReponse(isFraudCheck);
    }
}
