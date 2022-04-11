package com.robin.sollicitatie.repositories;

import com.robin.sollicitatie.models.Combination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombinationRepository extends JpaRepository<Combination, Integer> {

}
