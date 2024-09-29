package com.curriculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curriculo.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository <Project,Long> {
    
}
