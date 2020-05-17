package com.vboot.backend.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity(name = "Team")
@Table(name = "team")
@Data
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "team_id")
  private UUID teamID;

  @Column(name = "team_name")
  @Size(min = 4, max = 64, message = "The team name should be at least 4 characters long and at max 64 characters long.")
  @NotNull(message = "Team name cannot be empty")
  private String teamName;

  @Column(name = "team_description")
  private String teamDescription;

  @ManyToMany(
    fetch = FetchType.LAZY,
    cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
    },
    mappedBy = "teams"
  )
  private Set<Developer> developers = new HashSet<>();

}