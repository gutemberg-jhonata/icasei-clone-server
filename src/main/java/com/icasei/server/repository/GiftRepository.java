package com.icasei.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icasei.server.model.Gift;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {
    
}
