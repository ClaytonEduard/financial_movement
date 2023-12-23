package com.financialmovement.controllers;

import com.financialmovement.entities.Movement;
import com.financialmovement.repositories.MovementRepository;
import com.financialmovement.services.MovementService;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movements")
public class MovementController {

  /** Classe reposnsavel por todo gerenciamento de rotas */

  @Autowired
  private MovementService service;

}
