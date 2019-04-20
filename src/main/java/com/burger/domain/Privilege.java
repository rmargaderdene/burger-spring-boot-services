package com.burger.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final Long id;

	private final String name;

	@ManyToMany(mappedBy = "privileges")
	private Collection<Role> roles;
}