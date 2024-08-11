package com.example.skillsassignment.config.exceptions;

public class SkillsNotFoundException extends RuntimeException {

  public SkillsNotFoundException(Long id) {
    super(String.format("Could not find skill with id %s", id));
  }
}
