package com.curriculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curriculo.model.PersonalInfo;

public interface PersonalInfoRepository extends JpaRepository <PersonalInfo,Long> {
    
}
