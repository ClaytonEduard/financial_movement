package com.financialmovement.services;

import com.financialmovement.dto.MovementDTO;
import com.financialmovement.entities.Movement;
import com.financialmovement.repositories.MovementRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovementService {

  private MovementRepository movementRepository;

  // metodo listar todos
  public List<Movement> listAll() {
    return movementRepository.findAll();
  }

  // Metodo create
  public Movement create(Movement movement) {
    return movementRepository.save(movement);
  }

}
