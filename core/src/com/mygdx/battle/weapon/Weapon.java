package com.mygdx.battle.weapon;

import com.badlogic.gdx.math.Vector2;

public abstract class Weapon {
    protected float velocity;
    protected float projectileAmount = -1;
    public WeaponType weaponType = WeaponType.unarmed;

    public Weapon(float velocity) {
        this.velocity = velocity;
    }

    public enum WeaponType {
        spitter,
        unarmed
    }

    public abstract void attack(Vector2 shootDirection);
}
