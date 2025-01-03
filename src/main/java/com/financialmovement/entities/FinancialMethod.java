package com.financialmovement.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_financialmethod")
public class FinancialMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int percente;
    private String description;

    public FinancialMethod() {
    }

    public FinancialMethod(int percente, String description) {
        this.percente = percente;
        this.description = description;
    }

    public FinancialMethod(Long id, String description, int percente) {
        this.id = id;
        this.percente = percente;
        this.description = description;
    }

    public int getPercente() {
        return percente;
    }

    public void setPercente(int percente) {
        this.percente = percente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + percente;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
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
        FinancialMethod other = (FinancialMethod) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (percente != other.percente)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FinancialMethod [ percente= " + percente + ", description= " + description + "]";
    }

}
