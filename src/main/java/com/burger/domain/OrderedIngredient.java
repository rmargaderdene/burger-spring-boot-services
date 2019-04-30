package com.burger.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@IdClass(OrderedIngredientPK.class)
public class OrderedIngredient implements Serializable {

	public OrderedIngredient() {
	}

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order order;

	@Id
	@OneToOne
	@JoinColumn(name = "ingredient_id")
	private Ingredient ingredient;

	private Integer number;

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

class OrderedIngredientPK implements Serializable {
	private Long order;
	private Long ingredient;

	public OrderedIngredientPK() {
	}

	public OrderedIngredientPK(Long order_id, Long ingredient_id) {
		this.order = order_id;
		this.ingredient = ingredient_id;
	}
}
