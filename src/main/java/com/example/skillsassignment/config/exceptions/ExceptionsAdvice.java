package com.example.skillsassignment.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsAdvice {

  @ExceptionHandler(PeopleNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String peopleNotFoundException(PeopleNotFoundException e) {
    return e.getMessage();
  }

  @ExceptionHandler(SkillsNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String skillsNotFoundException(SkillsNotFoundException e) {
    return e.getMessage();
  }

  @ExceptionHandler(PeopleSkillsNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String peopleSkillsNotFoundException(PeopleSkillsNotFoundException e) {
    return e.getMessage();
  }
}
