package com.financialmovement.services;

import com.financialmovement.entities.FinancialMethod;
import com.financialmovement.repositories.FinancialMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialMethodService {

    public static final int LIMIT_PERCENT = 100;
    @Autowired
    private FinancialMethodRepository repository;

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

    public void updateFinancialMethod(FinancialMethod financialMethod, Long id) {
        repository.save(financialMethod);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public FinancialMethod getFinancialMethodById(long id) {
        return repository.findById(id).get();
    }

}
