package com.financialmovement.dto;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.financialmovement.entities.Category;
import com.financialmovement.entities.Movement;

public class MovementDTO  extends AbstractPersistable<Long>{
    private Category categoryid;
    private String description;

    public MovementDTO(){

    }

    public MovementDTO(Movement entity){
        BeanUtils.copyProperties(entity, this);
    }

}
