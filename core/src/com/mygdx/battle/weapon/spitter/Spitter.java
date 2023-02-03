package com.mygdx.battle.weapon.spitter;


import com.badlogic.gdx.math.Vector2;
import com.mygdx.battle.weapon.Weapon;

public class Spitter extends Weapon {
    Vector2 launchPos;
    public Spitter(Vector2 launchPos) {
        this.launchPos = launchPos;
        projectileAmount = 1;
        projectileVelocity = 10f;
        weaponType = WeaponType.spitter;
    }

    @Override
    public void attack(Vector2 shootDirection) {
        SpitterProjectile projectile = new SpitterProjectile(launchPos, 500f);
        projectile.launch(- shootDirection.angleDeg() - 45);
    }
}
