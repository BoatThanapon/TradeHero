package edu.se444.tradehero.service;

import edu.se444.tradehero.model.Hero;
import edu.se444.tradehero.model.Player;
import edu.se444.tradehero.repository.HeroRepository;
import edu.se444.tradehero.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    HeroRepository heroRepository;

    public Player getPlayerById(String playerId){
        Player player = playerRepository.findOne(playerId);
        return player;
    }

    public String addPlayer(Player player) {
        if (player == null){
            return null;
        }
        playerRepository.save(player);

        return player.getPlayerId();
    }

    public String updatePlayer(String playerId, Player player){
        if (playerId != null){
            Player findPlayer = getPlayerById(playerId);
            if (playerId != null){
                findPlayer.setPlayerName(player.getPlayerName());
                findPlayer.setPocketMoney(player.getPocketMoney());
                playerRepository.save(findPlayer);
                return player.getPlayerId();
            }
            return null;
        }
        return null;
    }


    public boolean buyHero(String playerId, Hero hero,String heroId) {
        Player findPlayer = getPlayerById(playerId);
        if (findPlayer == null) {
            return false;
        }
        Hero findHero = heroRepository.findOne(heroId);
        if (findHero == null) {
            return false;
        }
        int playerPoketMoney = findPlayer.getPocketMoney()-findHero.getPrice();
        findPlayer.setPocketMoney(playerPoketMoney);

        Hero myHero = new Hero();
        myHero.setHeroId(Long.toHexString(Double.doubleToLongBits(Math.random())));
        myHero.setHeroName(findHero.getHeroName());
        myHero.setPrice(findHero.getPrice());
        myHero.setType(findHero.getType());
        myHero.setPower(findHero.getPower());

        findPlayer.getMyHero().add(myHero);
        playerRepository.save(findPlayer);

        return true;
    }

    public boolean sellHero(String playerId, String heroId) {
        Player findPlayer = getPlayerById(playerId);
        if (findPlayer == null) {
            return false;
        }

//        for (Hero hero : myHero) {
//            if (hero.getHeroId().equals(heroId)) {
//                Hero findHero = hero;
//                if (findHero == null) {
//                    return false;
//                }
//                int playerPoketMoney = findPlayer.getPocketMoney()+ findHero.getPrice();
//                findPlayer.setPocketMoney(playerPoketMoney);
//
//                findPlayer.getMyHero().remove(findHero);
//                playerRepository.save(findPlayer);
//
//                return true;
//            }
//        }

        Hero findHero =  findPlayer.getMyHero().stream().filter(item -> item.getHeroId().equals(heroId)).findFirst().get();

        int playerPoketMoney = findPlayer.getPocketMoney()+ findHero.getPrice();
        findPlayer.setPocketMoney(playerPoketMoney);

        findPlayer.getMyHero().remove(heroId);
        playerRepository.save(findPlayer);

        return true;
    }

    public List<Player> getAllPlayer(){
        List<Player> playerList= playerRepository.findAll();
        return playerList;
    }

    public boolean deletePlayer(String playerId) {
        Player findPlayer = getPlayerById(playerId);
        if (findPlayer == null){
            return false;
        }
        playerRepository.delete(findPlayer);
        return true;
    }

}
