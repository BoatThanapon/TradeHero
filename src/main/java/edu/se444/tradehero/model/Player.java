package edu.se444.tradehero.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Players")
public class Player {
    @Id
    private String playerId;
    private String playerName;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int pocketMoney;
    private List<Hero> myHero;

    protected Player() {
    }

    public Player(String playerId, String playerName, int pocketMoney, List<Hero> myHero) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.pocketMoney = pocketMoney;
        this.myHero = myHero;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPocketMoney() {
        return pocketMoney;
    }

    public List<Hero> getMyHero() {
        return myHero;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPocketMoney(int pocketMoney) {
        this.pocketMoney = pocketMoney;
    }

    public void setMyHero(List<Hero> myHero) {
        this.myHero = myHero;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId='" + playerId + '\'' +
                ", playerName='" + playerName + '\'' +
                ", pocketMoney=" + pocketMoney +
                ", myHero=" + myHero +
                '}';
    }
}
