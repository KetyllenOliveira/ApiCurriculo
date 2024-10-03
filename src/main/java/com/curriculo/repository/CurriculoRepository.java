package com.curriculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curriculo.model.Curriculo;

@Repository
public interface CurriculoRepository extends JpaRepository <Curriculo,Long> {
    
}
