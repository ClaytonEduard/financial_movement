package com.financialmovement.controllers;

import com.financialmovement.entities.FinancialMethod;
import com.financialmovement.services.FinancialMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/financialmethod/{id}")
    public FinancialMethod getFinancialMethodsById(@PathVariable("id") long id) {
        return methodService.getFinancialMethodById(id);
    }

    @DeleteMapping("/financialmethod/{id}")
    private void deleteFinancialMethod(@PathVariable("id") long id) {
        methodService.delete(id);
        ;
    }

}
