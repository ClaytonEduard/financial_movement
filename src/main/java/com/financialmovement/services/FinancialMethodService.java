package com.financialmovement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financialmovement.entities.FinancialMethod;
import com.financialmovement.repositories.FinancialMethodRepository;

@Service
public class FinancialMethodService {

    @Autowired
    private FinancialMethodRepository repository;
    private static final int LIMIT_PERCENT = 100;

    public List<FinancialMethod> getFinancialMethods() {
        return (List<FinancialMethod>) repository.findAll();
    }

    public void saveOrdUpdate(FinancialMethod financialMethod) {

        int sumThis = calcSumTotal();
        if (sumThis + financialMethod.getPercente() > LIMIT_PERCENT) {
            throw new IllegalArgumentException("A soma total não pode exceder 100%");
        }
        repository.save(financialMethod);
    }

    private int calcSumTotal() {
        List<FinancialMethod> financialMethods = (List<FinancialMethod>) repository.findAll();
        return financialMethods.stream().mapToInt(FinancialMethod::getPercente).sum();
    }

}
