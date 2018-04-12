/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Collection;
import java.util.List;

/**
 * Repository class for <code>Pet</code> domain objects All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Daniel Jahre
 */
public interface PetRepository extends Neo4jRepository<Pet, Long> {

    /**
     * Retrieve all Pet types from the data store.
     * @return a Collection of pet types.
     */
    @Query("MATCH (n:Pet) return distinct labels(n)")
    List<Collection<String>> getPetTypes();

    /**
     * Retrieve a {@link Pet} from the data store by id.
     * @param id the id to search for
     * @return the {@link Pet} if found
     */
    Pet findById(long id);

    /**
     * Save a {@link Pet} to the data store, either inserting or updating it.
     * @param pet the {@link Pet} to save
     */
    Pet save(Pet pet);

}

