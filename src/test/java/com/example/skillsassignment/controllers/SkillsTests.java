package com.example.skillsassignment.controllers;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.skillsassignment.entity.Skills;
import com.example.skillsassignment.repository.SkillsRepository;
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
public class SkillsTests {
  @Autowired private SkillsRepository skillsRepository;
  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;

  @Test
  @DisplayName("Create Skills record")
  public void createSkillsRecord() throws Exception {
    Skills skills = Skills.builder().id(1L).description("Test").build();
    mockMvc
        .perform(
            post("/api/skills")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(skills)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.description").value("Test"));
  }

  @Test
  @DisplayName("Retrieve Skills record")
  public void retrieveSkillsRecord() throws Exception {
    Skills skills = Skills.builder().id(1L).description("Test").build();
    Skills savedSkills = skillsRepository.save(skills);

    mockMvc
        .perform(get("/api/skills/{id}", savedSkills.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(savedSkills.getId()))
        .andExpect(jsonPath("$.description").value("Test"));
  }

  @Test
  @DisplayName("Update Skills record")
  public void updateSkillsRecord() throws Exception {
    Skills skills = Skills.builder().id(1L).description("Test").build();
    skillsRepository.save(skills);

    Skills updatedSkills = Skills.builder().description("Amended").build();
    mockMvc
        .perform(
            put("/api/skills/{id}", skills.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedSkills)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.description").value("Amended"));
  }

  @Test
  @DisplayName("Delete Skills record")
  public void testDeleteEntity() throws Exception {
    Skills skills = Skills.builder().id(1L).description("Test").build();
    skillsRepository.save(skills);

    mockMvc.perform(delete("/api/skills/{id}", skills.getId())).andExpect(status().isOk());
  }
}
