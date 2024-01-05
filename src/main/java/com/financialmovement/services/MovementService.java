package com.financialmovement.services;

import com.financialmovement.entities.FinancialMethod;
import com.financialmovement.entities.Movement;
import com.financialmovement.repositories.MovementRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService {

  @Autowired
  private MovementRepository movementRepository;
  @Autowired
  private FinancialMethodService financialMethodService;
  private List<FinancialMethod> methods = new ArrayList<>();

  // metodo listar todos
  public List<Movement> listAll() {
    return movementRepository.findAll();
  }

  // Metodo create
  public Movement create(Movement movement) {
    return movementRepository.save(movement);
  }

  // verificar se, quais foram os metodos cadastrados?
  public List<FinancialMethod> financialMethods() {
    methods = financialMethodService.getFinancialMethods();
    return methods.stream().toList();
  }
}
