package com.example.skillsassignment.controllers;

import com.example.skillsassignment.config.exceptions.PeopleNotFoundException;
import com.example.skillsassignment.entity.PeopleSkills;
import com.example.skillsassignment.service.PeopleSkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people-skills")
public class PeopleSkillsController {
  @Autowired private PeopleSkillsService peopleSkillsService;

  @GetMapping
  private List<PeopleSkills> findAll() {
    return peopleSkillsService.findAll();
  }

  @GetMapping("/{id}")
  private PeopleSkills findById(@PathVariable Long id) {
    return peopleSkillsService.findById(id).orElseThrow(() -> new PeopleNotFoundException(id));
  }

  @PostMapping
  private PeopleSkills save(@RequestBody PeopleSkills peopleSkills) {
    return peopleSkillsService.save(peopleSkills);
  }

  @PutMapping("/{id}")
  PeopleSkills update(@PathVariable Long id, @RequestBody PeopleSkills peopleSkills) {

    return peopleSkillsService.save(id, peopleSkills);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deletePeopleSkills(@PathVariable Long id) {
    peopleSkillsService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
