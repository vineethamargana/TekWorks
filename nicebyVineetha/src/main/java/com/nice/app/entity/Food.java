package com.nice.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "food")
    private List<VegItem> vegItems;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "food")
    private List<NonVegItem> nonVegItems;

    
    public Food(List<VegItem> vegItems, List<NonVegItem> nonVegItems) {
        this.vegItems = vegItems;
        this.nonVegItems = nonVegItems;
    }


    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public List<VegItem> getVegItems() {
        return vegItems;
    }

    public void setVegItems(List<VegItem> vegItems) {
        this.vegItems = vegItems;
    }

    public List<NonVegItem> getNonVegItems() {
        return nonVegItems;
    }

    public void setNonVegItems(List<NonVegItem> nonVegItems) {
        this.nonVegItems = nonVegItems;
    }
}
