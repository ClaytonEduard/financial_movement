package com.financialmovement.controllers;

import com.financialmovement.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movements")
public class MovementController {

  @Autowired
  private MovementRepository movementRepository;

  

}
