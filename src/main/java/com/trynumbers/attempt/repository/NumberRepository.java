package com.trynumbers.attempt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trynumbers.attempt.entity.NaturalNumber;

@Repository
public interface NumberRepository extends JpaRepository<NaturalNumber, Long> {

}
