package cn.credit.checker.CreditChecker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditController {

    @GetMapping("/contract/init")
    public ResponseEntity<?> initializeContract() {
//        return new ResponseEntity<>(new Bazz(id, "Bazz"+id), HttpStatus.OK);
        return null;
    }
}
