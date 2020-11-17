package com.hussain.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.hussain.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

}
