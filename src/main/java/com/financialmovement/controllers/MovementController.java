package com.financialmovement.controllers;

import com.financialmovement.services.MovementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movements")
public class MovementController {

  /** Classe reposnsavel por todo gerenciamento de rotas */

  @Autowired
  private MovementService service;

}
