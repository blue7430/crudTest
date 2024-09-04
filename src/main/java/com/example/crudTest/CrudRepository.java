package com.example.crudTest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<Crud, Integer> {
}
