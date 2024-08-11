package com.example.skillsassignment.repository;

import com.example.skillsassignment.entity.People;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PeopleRepository extends JpaRepository<People, Long> {

  @Query("SELECT p FROM People p LEFT JOIN FETCH p.peopleSkills WHERE p.id = :id")
  Optional<People> findByIdWithSkills(@Param("id") Long id);
}
