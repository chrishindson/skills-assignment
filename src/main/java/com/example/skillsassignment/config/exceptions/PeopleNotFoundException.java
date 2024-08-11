package com.example.skillsassignment.config.exceptions;

public class PeopleNotFoundException extends RuntimeException {
  public PeopleNotFoundException(Long id) {
    super(String.format("People with id %s not found", id));
  }
}
