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
package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.*;
import org.springframework.samples.petclinic.repository.CityRepository;
import org.springframework.samples.petclinic.repository.PersonRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.cache.annotation.CacheResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    private PetRepository petRepository;
    private VetRepository vetRepository;
    private PersonRepository personRepository;
    private VisitRepository visitRepository;
    private CityRepository cityRepository;

    @Autowired
    public ClinicServiceImpl(PetRepository petRepository, VetRepository vetRepository,
                             PersonRepository personRepository, VisitRepository visitRepository,
                             CityRepository cityRepository) {
        this.petRepository = petRepository;
        this.vetRepository = vetRepository;
        this.personRepository = personRepository;
        this.visitRepository = visitRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public Collection<PetType> getPetTypes() throws DataAccessException {
        HashMap<String, PetType> petTypes = new HashMap();
        for (Collection<String> c : petRepository.getPetTypes()) {
            for (String entry : c) {
                if("BaseEntity".equals(entry) || "Pet".equals(entry)) {
                    continue;
                }
                petTypes.put(entry, new PetType(entry));
            }
        }
        return petTypes.values();
    }

    @Override
    public Person findOwnerById(long id) throws DataAccessException {
        return personRepository.findById(id).get();
    }

    @Override
    public Collection<Person> findAll() throws DataAccessException {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        return personList;
    }

    @Override
    @Transactional
    public void saveOwner(Person owner, String cityName) throws DataAccessException {
        if(cityName != null) {
            City city = cityRepository.findByName(cityName);
            if (city == null) {
                city = new City();
                city.setName(cityName);
            }
            owner.setCity(city);
        }
        personRepository.save(owner);
    }


    @Override
    @Transactional
    public void saveVisit(Visit visit) throws DataAccessException {
        visitRepository.save(visit);
    }


    @Override
    public Pet findPetById(long id) throws DataAccessException {
        return petRepository.findById(id);
    }

    @Override
    @Transactional
    public void savePet(Pet pet) throws DataAccessException {
        petRepository.save(pet);
    }

    @Override
    @Transactional(readOnly = true)
    @CacheResult(cacheName = "vets")
    public Collection<Vet> findVets() throws DataAccessException {
        return vetRepository.findAll();
    }

}
