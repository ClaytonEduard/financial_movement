package com.financialmovement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.financialmovement.entities.FinancialMethod;

public interface FinancialMethodRepository extends CrudRepository<FinancialMethod, Long> {

}
