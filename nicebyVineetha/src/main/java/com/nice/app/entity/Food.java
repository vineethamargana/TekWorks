package com.nice.app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    private String foodType;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")  // Creates a foreign key in NonVegItem referencing Food
    private List<VegItem> vegItems;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")  // Creates a foreign key in NonVegItem referencing Food
    private List<NonVegItem> nonVegItems;

    
    
    public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	public Food(Long foodId, String foodType, List<VegItem> vegItems, List<NonVegItem> nonVegItems) {
		super();
		this.foodId = foodId;
		this.foodType = foodType;
		this.vegItems = vegItems;
		this.nonVegItems = nonVegItems;
	}



	public Food(String foodType,List<VegItem> vegItems, List<NonVegItem> nonVegItems) {
		this.foodType = foodType;
        this.vegItems = vegItems;
        this.nonVegItems = nonVegItems;
    }
	
	


    /**
	 * @return the foodType
	 */
	public String getFoodType() {
		return foodType;
	}


	/**
	 * @param foodType the foodType to set
	 */
	public void setFoodType(String foodType) {
		this.foodType = foodType;
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
