package com.vboot.backend.repository;

import java.util.UUID;

import com.vboot.backend.model.Team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, UUID> {
  
}