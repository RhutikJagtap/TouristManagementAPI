package com.rj.TouristManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tourist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long touristId;
	
	private String touristName;
	
	private String packageType;
	
	private Double budget;
	
	public Tourist() {
	}
	
	

	public Tourist(Long touristId, String touristName, String packageType, Double budget) {
		super();
		this.touristId = touristId;
		this.touristName = touristName;
		this.packageType = packageType;
		this.budget = budget;
	}



	public Long getTouristId() {
		return touristId;
	}

	public void setTouristId(Long touristId) {
		this.touristId = touristId;
	}

	public String getTouristName() {
		return touristName;
	}

	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}
	
	@Override
	public String toString() {
		
		return touristId+" "+touristName+" "+packageType+" "+budget;
	}
	
	
	

}
