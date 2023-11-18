package com.cali.citeats.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblcuisinetype")
public class CuisineTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuisinetype_id")
    private int cuisineTypeId;

    @Column(name = "type_name", nullable = false)
    private String typeName;

    public CuisineTypeEntity() {
        super();
    }

    public CuisineTypeEntity(int cuisineTypeId, String typeName) {
        super();
        this.cuisineTypeId = cuisineTypeId;
        this.typeName = typeName;
    }

    public int getCuisineTypeId() {
        return cuisineTypeId;
    }

    public void setCuisineTypeId(int cuisineTypeId) {
        this.cuisineTypeId = cuisineTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
