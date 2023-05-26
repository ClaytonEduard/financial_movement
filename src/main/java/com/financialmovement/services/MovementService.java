package com.financialmovement.services;

import com.financialmovement.dto.MovementDTO;
import com.financialmovement.entities.Movement;
import com.financialmovement.repositories.MovementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovementService {

  private MovementRepository movementRepository;

  @Transactional(readOnly = true)
  public MovementDTO findById(Long id) {
    Movement result = movementRepository.findById(id).get();
    return new MovementDTO(result);
  }
}
