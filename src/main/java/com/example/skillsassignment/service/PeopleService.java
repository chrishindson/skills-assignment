package com.example.skillsassignment.service;

import com.example.skillsassignment.entity.People;
import com.example.skillsassignment.repository.PeopleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
  private final PeopleRepository peopleRepository;

  public PeopleService(PeopleRepository peopleRepository) {
    this.peopleRepository = peopleRepository;
  }

  public List<People> findAll() {
    return peopleRepository.findAll();
  }

  public People save(People people) {
    return peopleRepository.save(people);
  }

  public Optional<People> findByIdWithSkills(Long id) {
    return peopleRepository.findByIdWithSkills(id);
  }

  public Optional<People> findById(Long id) {
    return peopleRepository.findById(id);
  }

  public void deleteById(Long id) {
    peopleRepository.deleteById(id);
  }
}
