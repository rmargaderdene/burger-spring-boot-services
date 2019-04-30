package com.burger.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Long id;

	public Order() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

//	@OneToMany(mappedBy = "order", orphanRemoval = true)
//	private List<OrderedIngredient> orderedIngredients;

	@NotBlank(message = "Invalid phone number")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNumber;

	@NotBlank(message = "Username is required")
	private String username;

	@NotBlank(message = "Address is required")
	private String address;

	@NotBlank(message = "Price is required")
	private String price;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date createdDate;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updatedDate;

	@PrePersist
	protected void onCreate() {
		this.createdDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedDate = new Date();
	}
}
