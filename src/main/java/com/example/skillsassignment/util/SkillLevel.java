package com.example.skillsassignment.util;

import lombok.Getter;

@Getter
public enum SkillLevel {
  EXPERT(1, "Expert"),
  PRACTITIONER(2, "Practitioner"),
  WORKING(3, "Working"),
  AWARENESS(4, "Awareness");

  private final int level;
  private final String description;

  SkillLevel(int level, String description) {
    this.level = level;
    this.description = description;
  }
}
