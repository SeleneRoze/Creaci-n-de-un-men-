package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface MenuRepositories extends JpaRepository <MenuRepositories, Long> {

}
