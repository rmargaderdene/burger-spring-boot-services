package com.burger.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.burger.domain.Privilege;

@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
}
