package com.vboot.backend.repository;

import java.util.List;
import java.util.UUID;

import com.vboot.backend.model.Developer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, UUID> {
  @Override
  List<Developer> findAll();
}