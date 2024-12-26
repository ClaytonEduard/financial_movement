package com.financialmovement.repositories;

import com.financialmovement.entities.Movement;
import org.springframework.data.repository.CrudRepository;

public interface MovementRepository extends CrudRepository<Movement, Long> {

}