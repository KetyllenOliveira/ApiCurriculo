package com.curriculo.controller;

import com.curriculo.model.PersonalInfo;
import com.curriculo.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personalinfo")
public class PersonalInfoController {

    private final PersonalInfoRepository personalInfoRepository;

    @Autowired
    public PersonalInfoController(PersonalInfoRepository personalInfoRepository) {
        this.personalInfoRepository = personalInfoRepository;
    }

    /**
     * Retrieves a list of all personal information entries.
     * 
     * @return a list of PersonalInfo objects
     */
    @GetMapping
    public ResponseEntity<List<PersonalInfo>> getAllPersonalInfo() {
        List<PersonalInfo> personalInfoList = personalInfoRepository.findAll();
        return ResponseEntity.ok(personalInfoList);
    }

    /**
     * Retrieves personal information by ID.
     * 
     * @param id the ID of the personal information entry
     * @return ResponseEntity containing the PersonalInfo object, if found
     */
    @GetMapping("/{id}")
    public ResponseEntity<PersonalInfo> getPersonalInfoById(@PathVariable Long id) {
        return personalInfoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new personal information entry.
     * 
     * @param personalInfo the PersonalInfo object to be created
     * @return ResponseEntity containing the created PersonalInfo object
     */
    @PostMapping
    public ResponseEntity<PersonalInfo> createPersonalInfo(@RequestBody PersonalInfo personalInfo) {
        PersonalInfo createdInfo = personalInfoRepository.save(personalInfo);
        return ResponseEntity.status(201).body(createdInfo);
    }

    /**
     * Updates an existing personal information entry.
     * 
     * @param id the ID of the personal information entry to update
     * @param personalInfoDetails the updated details of PersonalInfo
     * @return ResponseEntity containing the updated PersonalInfo object, if found
     */
    @PutMapping("/{id}")
    public ResponseEntity<PersonalInfo> updatePersonalInfo(@PathVariable Long id, 
                                                           @RequestBody PersonalInfo personalInfoDetails) {
        return personalInfoRepository.findById(id)
                .map(existingInfo -> {
                    // Atualiza os campos do objeto existente
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

    /**
     * Deletes a personal information entry by ID.
     * 
     * @param id the ID of the personal information entry to delete
     * @return ResponseEntity indicating the result of the deletion
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePersonalInfo(@PathVariable Long id) {
        return personalInfoRepository.findById(id)
                .map(existingInfo -> {
                    personalInfoRepository.delete(existingInfo);
                    return ResponseEntity.noContent().build(); // 204 No Content if deletion is successful
                })
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found if entry does not exist
    }
}
