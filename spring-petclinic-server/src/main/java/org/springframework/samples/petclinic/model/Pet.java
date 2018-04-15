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
package org.springframework.samples.petclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * NodeEntity for Pet
 *
 * @author Daniel Jahre
 */
@NodeEntity
public class Pet extends BaseEntity {

    @JsonIgnore
    @Labels
    List<String> labels = new ArrayList<>();

    String name;

    @Property(name = "birthdate")
    LocalDate birthDate;

    @JsonIgnore
    @Relationship(type="OWNS", direction = Relationship.INCOMING)
    private Person owner;

    @Relationship(type = "WAS_ON")
    private Set<Visit> visits = new HashSet<>();


    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public List<Visit> getVisits() {
        return new ArrayList<>(visits);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getType() {
        if(!labels.isEmpty()) return labels.get(0);
        return "";
    }

    public void setType(String type) {
        labels.clear();
        labels.add(type);
    }
}
