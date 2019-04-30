package com.burger.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.burger.domain.OrderedIngredient;

@Repository
public interface OrderedIngredientRepository extends CrudRepository<OrderedIngredient, Long> {

}
