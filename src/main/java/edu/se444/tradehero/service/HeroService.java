package edu.se444.tradehero.service;

import edu.se444.tradehero.model.Hero;
import edu.se444.tradehero.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    HeroRepository heroRepository;

    public List<Hero> getAllHero(){
        List<Hero> heroList = heroRepository.findAll();
        return heroList;
    }

    public Hero getHeroById(String heroId){
        Hero hero = heroRepository.findOne(heroId);
        return hero;
    }

    public boolean addHero(Hero hero) {
        if (hero == null){
            return false;
        }
        heroRepository.save(hero);
        return true;
    }

    public boolean updateHero(String heroId, Hero hero){
        if (heroId != null){
            Hero findHero = getHeroById(heroId);
            if (findHero != null){
                findHero.setHeroName(hero.getHeroName());
                findHero.setPrice(hero.getPrice());
                findHero.setType(hero.getType());
                findHero.setPower(hero.getPower());

                heroRepository.save(findHero);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean deleteHero(String heroId) {
        Hero findHero = getHeroById(heroId);
        if (findHero == null){
            return false;
        }
        heroRepository.delete(findHero);
        return true;
    }

}
