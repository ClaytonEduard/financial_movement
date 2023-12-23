package com.financialmovement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.financialmovement.entities.FinancialMethod;
import com.financialmovement.services.FinancialMethodService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FinancialMethodController {

    @Autowired
    FinancialMethodService methodService;

    @PostMapping("/financialmethod")
    public void saveFinacialMethod(@RequestBody FinancialMethod financialMethod) {
        methodService.saveOrdUpdate(financialMethod);
    }

    @GetMapping("/financialmethod")
    public List<FinancialMethod> getAllFinancialMethods() {
        return methodService.getFinancialMethods();
    }

}
