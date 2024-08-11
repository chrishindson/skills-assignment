package com.example.skillsassignment.model;

import com.example.skillsassignment.util.SkillLevel;
import java.io.Serializable;
import lombok.Value;

/** DTO for {@link com.example.skillsassignment.entity.PeopleSkills} */
@Value
public class PeopleSkillsDto implements Serializable {
  Long id;
  Long peopleId;
  Long skillId;
  SkillLevel skillLevel;
}
