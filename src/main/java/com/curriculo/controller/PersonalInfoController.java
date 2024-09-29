package com.curriculo.controller;

import com.curriculo.model.PersonalInfo;
import com.curriculo.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<PersonalInfo> createPersonalInfo(@RequestBody PersonalInfo personalInfo) {
        PersonalInfo createdInfo = personalInfoRepository.save(personalInfo);
        return ResponseEntity.status(201).body(createdInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalInfo> updatePersonalInfo(@PathVariable Long id, @RequestBody PersonalInfo personalInfoDetails) {
        return personalInfoRepository.findById(id)
                .map(existingInfo -> {
                    existingInfo.setName(personalInfoDetails.getName());
                    existingInfo.setEmail(personalInfoDetails.getEmail());
                    existingInfo.setPhoneNumber(personalInfoDetails.getPhoneNumber());
                    existingInfo.setAddress(personalInfoDetails.getAddress());
                    existingInfo.setLinkedinProfile(personalInfoDetails.getLinkedinProfile());
                    existingInfo.setGithubProfile(personalInfoDetails.getGithubProfile());
                    existingInfo.setObjective(personalInfoDetails.getObjective());
                    PersonalInfo updatedInfo = personalInfoRepository.save(existingInfo);
                    return ResponseEntity.ok(updatedInfo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePersonalInfo(@PathVariable Long id) {
        return personalInfoRepository.findById(id)
                .map(existingInfo -> {
                    personalInfoRepository.delete(existingInfo);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
