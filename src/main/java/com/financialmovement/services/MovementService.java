package com.financialmovement.services;

import com.financialmovement.entities.FinancialMethod;
import com.financialmovement.entities.Movement;
import com.financialmovement.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;
    @Autowired
    private FinancialMethodService financialMethodService;


    private List<FinancialMethod> methods = new ArrayList<>();

    // metodo listar todos
    public List<Movement> listAll() {
        return (List<Movement>) movementRepository.findAll();
    }

    // Metodo create
    public Movement create(Movement movement) {
        movementRepository.save(movement);
        return movement;
    }

    // verificar se, quais foram os metodos cadastrados?
    public List<FinancialMethod> financialMethods() {
        methods = financialMethodService.getFinancialMethods();
        return methods.stream().toList();
    }

    public void update(Movement movement, long id) {

        Movement movementUpd = movementRepository.findById(id).get();
        // verifica a descricao
        if (Objects.nonNull(movement.getDescription()) && !"".equalsIgnoreCase(movement.getDescription())) {
            movementUpd.setDescription(movement.getDescription());
        }
        // verifica a data de input


    }


}
