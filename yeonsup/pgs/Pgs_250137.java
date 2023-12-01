package pgs;

import java.util.LinkedList;
import java.util.Queue;

public class Pgs_250137 {

    public static void main(String[] args) {
//        int[] bondage = {5, 1, 5};
//        int health = 30;
//        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        int[] bondage = {1, 1, 1};
        int health = 5;
        int[][] attacks = {{1, 2}, {3, 2}};
        new Pgs_250137().solution(bondage, health, attacks);
    }
    //                  시전시간,회복량,추획 / 체력       / 시간, 데미지
    public int solution(int[] bandage, int health, int[][] attacks) {
        Queue<Enemy> enemies = new LinkedList<>();
        int time = 0;

        Healer healer = new Healer(bandage[0], bandage[1], bandage[2], health);
        for (int[] attack : attacks) {
            enemies.add(new Enemy(attack[0], attack[1]));
        }

        while (healer.isLive() && !enemies.isEmpty()) {
            time++;
            if (enemies.peek().compareTime(time)) {
                Enemy enemy = enemies.poll();
                enemy.attackHealer(healer);
            } else {
                healer.selfHeal();
            }
        }
        System.out.println(healer.getHealth());
        return healer.getHealth();
    }
}

class Enemy {
    private int time;
    private int damage;

    public Enemy(int time, int damage) {
        this.time = time;
        this.damage = damage;
    }

    public void attackHealer(Healer healer) {
        healer.getDamage(damage);
    }

    public boolean compareTime(int time) {
        return this.time == time;
    }
}

class Healer {
    private int castingTime;
    private int amountOfRecovery;
    private int bonusRecovery;
    private int count;
    private int health;
    private int maxHealth;
    private boolean live = true;

    public Healer(int castingTime, int amountOfRecovery, int bonusRecovery, int health) {
        this.castingTime = castingTime;
        this.amountOfRecovery = amountOfRecovery;
        this.bonusRecovery = bonusRecovery;
        this.health = health;
        this.maxHealth = health;
        this.count = 0;
    }

    public void selfHeal() {

        health += amountOfRecovery;
        count++;
        if (count == castingTime) {
            health += bonusRecovery;
            count = 0;
        }

        if (health >= maxHealth) {
            health = maxHealth;
        }
    }

    public void getDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            live = false;
        }
        count = 0;
    }

    public boolean isLive() {
        if (!live) {
            health = -1;
        }
        return live;
    }

    public int getHealth() {
        return health;
    }
}
