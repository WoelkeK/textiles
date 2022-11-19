package com.ambitious.team.textiles.config.repository;

import com.ambitious.team.textiles.config.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}