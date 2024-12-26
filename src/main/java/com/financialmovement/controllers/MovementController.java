package com.financialmovement.controllers;

import com.financialmovement.entities.Movement;
import com.financialmovement.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovementController {

    /**
     * Classe reposnsavel por todo gerenciamento de rotas
     */

    @Autowired
    private MovementService service;

    // metodo save post
    @PostMapping("/movements")
    public void saveMovement(@RequestBody Movement movement) {
        service.create(movement);
    }

    // metodo de list
    @GetMapping("/movements")
    public List<Movement> getAllMovements() {
        return service.listAll();
    }

}
