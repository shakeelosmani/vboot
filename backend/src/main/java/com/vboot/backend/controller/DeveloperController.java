package com.vboot.backend.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.vboot.backend.model.Developer;
import com.vboot.backend.repository.DeveloperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/developer")
public class DeveloperController {

  @Autowired
  private DeveloperRepository developerRepository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ResponseEntity<List<Developer>> listAllDevelopers() {
    List<Developer> developers = developerRepository.findAll();
    return new ResponseEntity<List<Developer>>(developers, HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Developer> getDeveloper(@PathVariable("id") UUID id) {
    Optional<Developer> developer = developerRepository.findById(id);
    if(developer.isPresent()) {
      return new ResponseEntity<Developer>(developer.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}