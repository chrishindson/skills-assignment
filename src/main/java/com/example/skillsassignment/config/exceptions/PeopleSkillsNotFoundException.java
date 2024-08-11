package com.example.skillsassignment.config.exceptions;

public class PeopleSkillsNotFoundException extends RuntimeException {
  public PeopleSkillsNotFoundException(Long id) {
    super(String.format("People Skills with id %s not found", id));
  }
}
