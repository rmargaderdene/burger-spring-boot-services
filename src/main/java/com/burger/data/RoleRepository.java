package com.burger.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.burger.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findAllByName(String name);
}
