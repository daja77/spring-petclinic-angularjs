// Vets that are Surgeons and/or Dentists
CREATE(linda:Vet:Surgeon:Dentist {firstname: "Linda", lastname: "Douglas"})
CREATE(raf:Vet:Surgeon {firstname: "Rafael", lastname: "Ortega"})
//Radiologists
CREATE(helen:Vet:Radiologist {firstname: "Helen", lastname: "Leary"})
CREATE(henry:Vet:Radiologist {firstname: "Henry", lastname: "Stevens"})
//regular vets
CREATE(sharon:Vet {firstname: "Sharon", lastname: "Jenkins"})
CREATE(james:Vet {firstname: "James", lastname: "Carter"})

//Pets
CREATE(leo:Pet:Cat {name: "Leo", birthdate: "2010-09-07"})
CREATE(basil:Pet:Hamster {name: "Basil", birthdate: "2012-08-06"})
CREATE(rosy:Pet:Dog {name: "Rosy", birthdate: "2011-04-17"})
CREATE(jewel:Pet:Dog {name: "Jewel", birthdate: "2010-03-07"})
CREATE(iggy:Pet:Lizard {name: "Iggy", birthdate: "2010-11-30"})
CREATE(george:Pet:Snake {name: "George", birthdate: "2010-01-20"})
CREATE(sam:Pet:Cat {name: "Samantha", birthdate: "2012-09-04"})
CREATE(max:Pet:Cat {name: "Max", birthdate: "2012-09-04"})
CREATE(lucky:Pet:Bird {name: "Lucky", birthdate: "2011-08-06"})
CREATE(mull:Pet:Dog {name: "Mulligan", birthdate: "2007-02-24"})
CREATE(freddy:Pet:Bird {name: "Freddy", birthdate: "2010-03-09"})
CREATE(luck2:Pet:Dog {name: "Lucky", birthdate: "2010-06-24"})
CREATE(sly:Pet:Cat {name: "Sly", birthdate: "2012-06-08"})

//Cities
CREATE(mad:City {name: "Madison"})
CREATE(sun:City {name: "Sun Prairie"})
CREATE(macf:City {name: "McFarland"})
CREATE(windsor:City {name: "Windsor"})
CREATE(mono:City {name: "Monona"})
CREATE(waun:City {name: "Waunakee"})

//Persons (Owners of the pets) linked to the cities they live in
CREATE(franklin:Person {firstname: "George", lastname: "Franklin",
                        address: "110 W. Liberty St.",
                        telephone: "6085551023"
})
CREATE((franklin)-[:LIVES_IN]->(mad))

CREATE(betty:Person {firstname: "Betty", lastname: "Davis",
                     address: "638 Cardinal Ave.",
                     telephone: "6085551749"
})
CREATE((betty)-[:LIVES_IN]->(sun))

CREATE(ed:Person {firstname: "Eduardo", lastname: "Rodriquez",
                  address: "2693 Commerce St.",
                  telephone: "6085558763"
})
CREATE((ed)-[:LIVES_IN]->(mad))

CREATE(harold:Person {firstname: "Harold", lastname: "Davis",
                      address: "563 Friendly St.",
                      telephone: "6085553198"
})
CREATE((harold)-[:LIVES_IN]->(windsor))

CREATE(peter:Person {firstname: "Peter", lastname: "McTavish",
                     address: "2387 S. Fair Way",
                     telephone: "6085552765"
})
CREATE((peter)-[:LIVES_IN]->(mad))

CREATE(jean:Person {firstname: "Jean", lastname: "Coleman",
                    address: "105 N. Lake St.",
                    telephone: "6085552654"
})
CREATE((jean)-[:LIVES_IN]->(mono))

CREATE(jeff:Person {firstname: "Jeff", lastname: "Black",
                    address: "1450 Oak Blvd.",
                    telephone: "6085555387"
})
CREATE((jeff)-[:LIVES_IN]->(mono))

CREATE(maria:Person {firstname: "Maria", lastname: "Escobito",
                     address: "345 Maple St.",
                     telephone: "6085557683"
})
CREATE((maria)-[:LIVES_IN]->(mad))

CREATE(david:Person {firstname: "David", lastname: "Schroeder",
                     address: "2749 BlackHawk Trail",
                     telephone: "6085559435"
})
CREATE((david)-[:LIVES_IN]->(mad))

CREATE(carlos:Person {firstname: "Carlos", lastname: "Estaban",
                      address: "2335 Independence La.",
                      telephone: "6085555487"
})
CREATE((carlos)-[:LIVES_IN]->(waun))

//Ownership relations
CREATE((franklin)-[:OWNS]->(leo))
CREATE((betty)-[:OWNS]->(basil))
CREATE((ed)-[:OWNS]->(rosy))
CREATE((ed)-[:OWNS]->(jewel))
CREATE((harold)-[:OWNS]->(iggy))
CREATE((peter)-[:OWNS]->(george))
CREATE((jean)-[:OWNS]->(sam))
CREATE((jean)-[:OWNS]->(max))
CREATE((jeff)-[:OWNS]->(lucky))
CREATE((maria)-[:OWNS]->(mull))
CREATE((david)-[:OWNS]->(freddy))
CREATE((carlos)-[:OWNS]->(luck2))
CREATE((carlos)-[:OWNS]->(sly))

//Visit nodes
CREATE(v1:Visit {visit_date: "2013-01-01", description: "rabies shot"})
CREATE(v2:Visit {visit_date: "2013-01-02", description: "rabies shot"})
CREATE(v3:Visit {visit_date: "2013-01-03", description: "neutered"})
CREATE(v4:Visit {visit_date: "2013-01-04", description: "spayed"})

//Pets and Vets on the visits
CREATE((sam)-[:WAS_ON]->(v1))
CREATE((sharon)-[:MEDICATED_ON]->(v1))
CREATE((max)-[:WAS_ON]->(v2))
CREATE((james)-[:MEDICATED_ON]->(v2))
CREATE((max)-[:WAS_ON]->(v3))
CREATE((raf)-[:MEDICATED_ON]->(v3))
CREATE((sam)-[:WAS_ON]->(v4))
CREATE((linda)-[:MEDICATED_ON]->(v4))
