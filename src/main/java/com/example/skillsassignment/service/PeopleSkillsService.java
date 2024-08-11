package com.example.skillsassignment.service;

import com.example.skillsassignment.entity.PeopleSkills;
import com.example.skillsassignment.repository.PeopleSkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PeopleSkillsService {
  private final PeopleSkillsRepository peopleSkillsRepository;

  public PeopleSkillsService(PeopleSkillsRepository peopleSkillsRepository) {
    this.peopleSkillsRepository = peopleSkillsRepository;
  }

  public List<PeopleSkills> findAll() {
    return peopleSkillsRepository.findAll();
  }

  public Optional<PeopleSkills> findById(Long id) {
    return peopleSkillsRepository.findById(id);
  }

  public PeopleSkills save(Long id, PeopleSkills peopleSkills) {
    return peopleSkillsRepository
        .findById(id)
        .map(
            ps -> {
              ps.setPeople(peopleSkills.getPeople());
              ps.setSkill(peopleSkills.getSkill());
              ps.setSkillLevel(peopleSkills.getSkillLevel());
              return peopleSkillsRepository.save(ps);
            })
        .orElseGet(() -> peopleSkillsRepository.save(peopleSkills));
  }

  public PeopleSkills save(PeopleSkills peopleSkills) {
    return peopleSkillsRepository.save(peopleSkills);
  }

  public void deleteById(Long id) {
    peopleSkillsRepository.deleteById(id);
  }
}
