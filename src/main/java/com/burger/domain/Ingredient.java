package com.burger.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ingredient_id")
	private Long id;

	public Ingredient() {
	}

	public Ingredient(String name, Double price, Integer initNumber) {
		this.name = name;
		this.price = price;
		this.initNumber = initNumber;
	}

	@NotNull
	@Size(min = 3, message = "Name must be at least 3 characters long")
	@Column(unique = true)
	private String name;

	@NotBlank(message = "Price is required")
	private double price;

	@NotBlank(message = "Init number is required")
	private Integer initNumber;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date createdAt;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
