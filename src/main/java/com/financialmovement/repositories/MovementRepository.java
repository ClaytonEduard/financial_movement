package com.financialmovement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financialmovement.entities.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long>{

}