package edu.se444.tradehero.repository;

import edu.se444.tradehero.model.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero,String> {

}
