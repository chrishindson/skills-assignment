package com.example.skillsassignment.controllers;

import com.example.skillsassignment.config.exceptions.PeopleNotFoundException;
import com.example.skillsassignment.entity.People;
import com.example.skillsassignment.service.PeopleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

  @Autowired private PeopleService peopleService;

  @GetMapping
  public List<People> getAllPeople() {
    return peopleService.findAll();
  }

  @PostMapping
  public People createPeople(@RequestBody People people) {
    return peopleService.save(people);
  }

  @GetMapping("/{id}")
  public People getPeopleById(@PathVariable Long id) {
    return peopleService.findByIdWithSkills(id).orElseThrow(() -> new PeopleNotFoundException(id));
  }

  @PutMapping("/{id}")
  public People updatePeople(@PathVariable Long id, @RequestBody People people) {
    return peopleService
        .findById(id)
        .map(
            p -> {
              p.setForename(people.getForename());
              p.setSurname(people.getSurname());
              return peopleService.save(p);
            })
        .orElseGet(() -> peopleService.save(people));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deletePeople(@PathVariable Long id) {
    peopleService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
