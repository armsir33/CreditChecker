package cn.credit.checker.CreditChecker.controller;

import cn.credit.checker.CreditChecker.dto.CreditCheckerRequest;
import cn.credit.checker.CreditChecker.service.CreditCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditController {

    @Autowired
    private CreditCheckerService service;

    @PostMapping("/contract/init")
    public ResponseEntity<?> initializeContract(@RequestBody CreditCheckerRequest request) {
        return service.initiateContract(request);
    }
}
