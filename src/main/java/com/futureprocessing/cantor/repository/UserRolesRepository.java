package com.futureprocessing.cantor.repository;

import com.futureprocessing.cantor.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {
}
