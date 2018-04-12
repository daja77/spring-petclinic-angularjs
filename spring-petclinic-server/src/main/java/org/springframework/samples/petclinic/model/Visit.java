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

import com.fasterxml.jackson.annotation.JsonFormat;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDate;

/**
 * NodeEntity for Visit
 *
 * @author Daniel Jahre
 */
@NodeEntity
public class Visit extends BaseEntity {

    /**
     * Holds value of property date.
     */
    @Property(name = "visit_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    /**
     * Holds value of property description.
     */
    private String description;

    /**
     * Holds value of property pet.
     */
    @Relationship(type = "WAS_ON", direction = Relationship.INCOMING)
    private Pet pet;

    @Relationship(type = "MEDICATED_ON", direction = Relationship.INCOMING)
    private Vet vet;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
