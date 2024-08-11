package com.example.skillsassignment.controllers;

import com.example.skillsassignment.config.exceptions.SkillsNotFoundException;
import com.example.skillsassignment.entity.Skills;
import com.example.skillsassignment.service.SkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {

  @Autowired private SkillsService skillsService;

  @GetMapping
  public List<Skills> getAllSkills() {
    return skillsService.findAll();
  }

  @PostMapping
  public Skills createSkills(@RequestBody Skills skills) {
    return skillsService.save(skills);
  }

  @GetMapping("/{id}")
  public Skills getSkillsById(@PathVariable Long id) {
    return skillsService.findById(id).orElseThrow(() -> new SkillsNotFoundException(id));
  }

  @PutMapping("/{id}")
  public Skills updateSkills(@PathVariable Long id, @RequestBody Skills skills) {
    return skillsService
        .findById(id)
        .map(
            s -> {
              s.setDescription(skills.getDescription());
              return skillsService.save(skills);
            })
        .orElseGet(() -> skillsService.save(skills));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteSkills(@PathVariable Long id) {
    skillsService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
