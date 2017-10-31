package edu.se444.tradehero.controller;

import edu.se444.tradehero.model.Hero;
import edu.se444.tradehero.model.Player;
import edu.se444.tradehero.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/{playerId}")
    public Player detailPlayer(@PathVariable String playerId){
        return playerService.getPlayerById(playerId);
    }

    @PostMapping()
    public String addPlayer(@RequestBody Player player) {
        String addPlayer = playerService.addPlayer(player);
        if (addPlayer != null){
            return "Add Player Success\n" +"Player Id: "+ addPlayer;
        }
        return "Add Player Fault";
    }

    @PutMapping("/{playerId}")
    public String updatePlayer(@PathVariable String playerId, @RequestBody Player player) {
        String updatePlayer = playerService.updatePlayer(playerId,player);
        if (updatePlayer != null){
            return "Update Player Success\n" +"Player Id: "+ updatePlayer;
        }
        return "Update Player Fault";
    }

    @PostMapping("{playerId}/buyhero/{heroId}")
    public String buyHero(@PathVariable String playerId,@RequestBody Hero hero, @PathVariable String heroId) {
        boolean buyHero = playerService.buyHero(playerId, hero, heroId);
        if (buyHero == true){
            Player player = playerService.getPlayerById(playerId);
            return "My Poket Money: "+ player.getPocketMoney();
        }
        return "Buy Hero Fault";
    }

    @DeleteMapping("{playerId}/sellhero/{heroId}")
    public String sellHero(@PathVariable String playerId,@PathVariable String heroId) {
        boolean sellHero = playerService.sellHero(playerId, heroId);
        if (sellHero == true){
            Player player = playerService.getPlayerById(playerId);
            return "My Poket Money: "+ player.getPocketMoney();
        }
        return "Sell Hero Fault";
    }

    @DeleteMapping("/{playerId}")
    public String DeletePlayer(@PathVariable String playerId) {
        boolean deletePlayer = playerService.deletePlayer(playerId);
        if (deletePlayer == true){
            return "Delete Player Success";
        }
        return "Delete Player Fault";
    }

    @GetMapping()
    public List<Player> listPlayer(){
        return playerService.getAllPlayer();
    }
}
