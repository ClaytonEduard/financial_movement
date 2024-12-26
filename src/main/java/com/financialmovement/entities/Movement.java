package com.financialmovement.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_movements")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Type type; // tipo e um enum Receita, despesa, transferencia
    private String description;
    private Date dateInput = new Date();
    @ManyToOne
    private Category categoryId;
    @ManyToOne
    private SubCategory subCategoryId;


    private Double amount;
    private int numberInstallments;
    private List<Double> amoutInstallments;

    public Movement() {
    }

    public Movement(Long id, Type type, String description, Category categoryId,
                    SubCategory subCategoryId, Double amount, int numberInstallments, List<Double> amoutInstallments) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.dateInput = getDateInput();
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.amount = amount;
        this.numberInstallments = numberInstallments;
        this.amoutInstallments = amoutInstallments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateInput() {
        return dateInput;
    }

    public void setDateInput(Date dateInput) {
        this.dateInput = dateInput;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public SubCategory getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(SubCategory subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getNumberInstallments() {
        return numberInstallments;
    }

    public void setNumberInstallments(int numberInstallments) {
        this.numberInstallments = numberInstallments;
    }

    public List<Double> getAmoutInstallments() {
        /**
         *  Pega o valor total divide pela quantidade de parcelas
         */
        double amoutInstallment = amount / numberInstallments;
        List<Double> installments = new ArrayList<>();
        for (int i = 0; i < numberInstallments; i++) {
            installments.add(amoutInstallment);
        }
        return installments;
    }

    public void setAmoutInstallments(List<Double> amoutInstallments) {
        this.amoutInstallments = amoutInstallments;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movement other = (Movement) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
