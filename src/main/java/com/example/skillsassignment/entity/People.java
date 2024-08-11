package com.example.skillsassignment.entity;

import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "people")
public class People {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "forename", nullable = false, length = 100)
  private String forename;

  @Column(name = "surname", nullable = false, length = 100)
  private String surname;

  @OneToMany(mappedBy = "people", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  private Set<PeopleSkills> peopleSkills;
}
