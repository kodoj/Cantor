package com.futureprocessing.cantor.repository;

import com.futureprocessing.cantor.model.User;
import com.futureprocessing.cantor.model.UserRegistrationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    User save(UserRegistrationDto userRegistrationDto);
}
