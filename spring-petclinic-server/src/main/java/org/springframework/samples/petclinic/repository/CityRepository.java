package org.springframework.samples.petclinic.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.samples.petclinic.model.City;

public interface CityRepository extends Neo4jRepository<City, Long> {

    City findByName(String name);
}
