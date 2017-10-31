package edu.se444.tradehero.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

public class Hero {
    @Id
    private String heroId;
    private String heroName;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int price;
    private String type;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int power;

    public Hero() {
    }

    public Hero(String heroId, String heroName, int price, String type, int power) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.price = price;
        this.type = type;
        this.power = power;
    }

    public String getHeroId() {
        return heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
