package com.mygdx.battle.weapon.spitter;


import com.badlogic.gdx.math.Vector2;
import com.mygdx.battle.weapon.Weapon;

public class Spitter extends Weapon {
    private Vector2 offset;
    private Vector2 projectileStartPos = new Vector2();
    private float R;
    public Spitter(Vector2 offset, float R, float velocity) {
        super(velocity);
        this.offset = offset;
        this.R = R;
        projectileAmount = 1;
        weaponType = WeaponType.spitter;
    }

    @Override
    public void attack(Vector2 shootDirection) {
        projectileStartPos.set(((shootDirection.x * R) / shootDirection.len()),
                ((shootDirection.y * R) / shootDirection.len()));
        projectileStartPos.add(offset);
        Vector2 projectileVelocity = new Vector2();
        projectileVelocity.set(shootDirection);
        projectileVelocity.setLength(velocity);
        SpitterProjectile projectile = new SpitterProjectile(projectileStartPos);
        projectile.launch(projectileVelocity);
    }
}
