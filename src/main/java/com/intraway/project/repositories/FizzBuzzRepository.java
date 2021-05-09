package com.intraway.project.repositories;

import com.intraway.project.domains.FizzBuzz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FizzBuzzRepository extends JpaRepository<FizzBuzz, Long> {
}
