package com.example.skillsassignment.service;

import com.example.skillsassignment.entity.Skills;
import com.example.skillsassignment.repository.SkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SkillsService {
  private final SkillsRepository skillsRepository;

  public SkillsService(SkillsRepository skillsRepository) {
    this.skillsRepository = skillsRepository;
  }

  public List<Skills> findAll() {
    return skillsRepository.findAll();
  }

  public Skills save(Skills skills) {
    return skillsRepository.save(skills);
  }

  public Optional<Skills> findById(Long id) {
    return skillsRepository.findById(id);
  }

  public void deleteById(Long id) {
    skillsRepository.deleteById(id);
  }
}
