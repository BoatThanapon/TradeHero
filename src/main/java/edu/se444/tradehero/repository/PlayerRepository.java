package edu.se444.tradehero.repository;

import edu.se444.tradehero.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player,String> {

}
