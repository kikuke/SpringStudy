package com.kikuke.toy1.intObject;

public class IntObject {

    private Long id;
    private String name;
    private float hp;
    private float defence;
    private float damage;
    private float critical;
    private float avoidance;
    private float hitRate;

    public IntObject() {}

    public IntObject(Long id, String name, float hp, float defence, float damage, float critical, float avoidance, float hitRate) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.defence = defence;
        this.damage = damage;
        this.critical = critical;
        this.avoidance = avoidance;
        this.hitRate = hitRate;
    }

    public float getCritical() {
        return critical;
    }

    public void setCritical(float critical) {
        this.critical = critical;
    }

    public float getHitRate() {
        return hitRate;
    }

    public void setHitRate(float hitRate) {
        this.hitRate = hitRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getDefence() {
        return defence;
    }

    public void setDefence(float defence) {
        this.defence = defence;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getAvoidance() {
        return avoidance;
    }

    public void setAvoidance(float avoidance) {
        this.avoidance = avoidance;
    }

    @Override
    public String toString() {
        return "IntObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", defence=" + defence +
                ", damage=" + damage +
                ", critical=" + critical +
                ", avoidance=" + avoidance +
                ", hitRate=" + hitRate +
                '}';
    }
}
