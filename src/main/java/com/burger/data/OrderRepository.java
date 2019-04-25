package com.burger.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.burger.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

	Iterable<Order> findByUsername(String username);

	Order getById(Long id);
}
