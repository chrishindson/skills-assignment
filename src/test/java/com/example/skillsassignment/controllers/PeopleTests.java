package com.example.skillsassignment.controllers;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.skillsassignment.entity.People;
import com.example.skillsassignment.repository.PeopleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PeopleTests {
  @Autowired private PeopleRepository peopleRepository;
  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;

  @Test
  @DisplayName("Create People record")
  public void createPeopleRecord() throws Exception {
    People people = People.builder().id(1L).forename("Test").surname("User").build();
    mockMvc
        .perform(
            post("/api/people")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(people)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.forename").value("Test"))
        .andExpect(jsonPath("$.surname").value("User"));
  }

  @Test
  @DisplayName("Retrieve People record")
  public void retrievePeopleRecord() throws Exception {
    People people = People.builder().id(1L).forename("Test").surname("User").build();
    peopleRepository.save(people);

    mockMvc
        .perform(get("/api/people/{id}", people.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(people.getId()))
        .andExpect(jsonPath("$.forename").value("Test"))
        .andExpect(jsonPath("$.surname").value("User"));
  }

  @Test
  @DisplayName("Update People record")
  public void updatePeopleRecord() throws Exception {
    People people = People.builder().id(1L).forename("Test").surname("User").build();
    peopleRepository.save(people);

    People updatedPeople = People.builder().forename("Amended").surname("User").build();
    mockMvc
        .perform(
            put("/api/people/{id}", people.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedPeople)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(people.getId()))
        .andExpect(jsonPath("$.forename").value("Amended"))
        .andExpect(jsonPath("$.surname").value("User"));
  }

  @Test
  @DisplayName("Delete People record")
  public void testDeleteEntity() throws Exception {
    People people = People.builder().id(1L).forename("Test").surname("User").build();
    peopleRepository.save(people);

    mockMvc.perform(delete("/api/people/{id}", people.getId())).andExpect(status().isOk());
  }
}
