package com.WorkStride.fraud;
import com.WorkStride.clients.fraud.FraudCheckReponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {
    private final FraudServices fraudServices;

    @GetMapping(path="{customerId}")
    public FraudCheckReponse isFraudster(@PathVariable("customerId") Integer customerId) {
    boolean isFraudCheck =  fraudServices.isFraudulentCustomer(customerId);
    log.info("fraud check request for customer {}", customerId);
    return  new FraudCheckReponse(isFraudCheck);
    }
}
