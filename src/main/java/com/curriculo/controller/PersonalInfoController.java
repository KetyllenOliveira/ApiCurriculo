package com.curriculo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculo.model.PersonalInfo;
import com.curriculo.repository.PersonalInfoRepository;

@RestController
@RequestMapping("/api/personalinfo")

public class PersonalInfoController {
      @Autowired
    private PersonalInfoRepository personalInfoRepository;

    @GetMapping
    public List<PersonalInfo> getAllPersonalInfo() {
        return personalInfoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalInfo> getPersonalInfoById(@PathVariable Long id) {
        return personalInfoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PersonalInfo createPersonalInfo(@RequestBody PersonalInfo personalInfo) {
        return personalInfoRepository.save(personalInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalInfo> updatePersonalInfo(@PathVariable Long id, @RequestBody PersonalInfo personalInfoDetails) {
        return personalInfoRepository.findById(id)
                .map(personalInfo -> {
                    personalInfo.setName(personalInfoDetails.getName());
                    personalInfo.setEmail(personalInfoDetails.getEmail());
                    personalInfo.setPhoneNumber(personalInfoDetails.getPhoneNumber());
                    personalInfo.setAddress(personalInfoDetails.getAddress());
                    personalInfo.setLinkedinProfile(personalInfoDetails.getLinkedinProfile());
                    personalInfo.setGithubProfile(personalInfoDetails.getGithubProfile());
                    personalInfo.setObjective(personalInfoDetails.getObjective());
                    PersonalInfo updatedPersonalInfo = personalInfoRepository.save(personalInfo);
                    return ResponseEntity.ok(updatedPersonalInfo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePersonalInfo(@PathVariable Long id) {
        return personalInfoRepository.findById(id)
                .map(personalInfo -> {
                    personalInfoRepository.delete(personalInfo);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
