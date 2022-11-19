package com.ambitious.team.textiles.config.repository;

import com.ambitious.team.textiles.config.model.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends JpaRepository<Bag,Long> {
}
