package com.mygdx.battle.weapon;

import com.badlogic.gdx.math.Vector2;

public abstract class Weapon {
    protected float projectileVelocity = 10f;
    protected float projectileAmount = -1;
    protected int damage = 10;
    public WeaponType weaponType = WeaponType.unarmed;

    public Weapon() {

    }

    public enum WeaponType {
        spitter,
        unarmed
    }

    public abstract void attack(Vector2 shootDirection);
}
