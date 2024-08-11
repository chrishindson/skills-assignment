package com.example.skillsassignment.entity;

import com.example.skillsassignment.util.SkillLevel;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people_skills")
public class PeopleSkills {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  private Long people;
  private Long skill;

  @Enumerated(EnumType.ORDINAL)
  private SkillLevel skillLevel;
}
