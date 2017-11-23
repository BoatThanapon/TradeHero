package edu.se444.tradehero.controller;

import edu.se444.tradehero.model.Hero;
import edu.se444.tradehero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    HeroService heroService;

    @GetMapping("/hero")
    public Iterable<Hero> heroes() {
        return heroService.getAllHero();
    }

    @GetMapping("/hero/{heroId}")
    public Hero detailHero(@PathVariable String heroId){
        return heroService.getHeroById(heroId);
    }

    @PostMapping("/hero")
    public String addHero(@RequestBody Hero hero) {
        boolean addHero = heroService.addHero(hero);
        if (addHero == true){
            return "Add Success";
        }
        return "Add Fault";
    }

    @PutMapping("/hero/{heroId}")
    public String updateHero(@PathVariable String heroId,@RequestBody Hero hero) {
        boolean updateHero = heroService.updateHero(heroId,hero);
        if (updateHero == true){
            return "Update Success";
        }
        return "Update Fault";
    }

    @DeleteMapping("/hero/{heroId}")
    public String delete(@PathVariable String heroId) {
        boolean updateHero = heroService.deleteHero(heroId);
        if (updateHero == true){
            return "Delete Success";
        }
        return "Delete Fault";
    }

}
