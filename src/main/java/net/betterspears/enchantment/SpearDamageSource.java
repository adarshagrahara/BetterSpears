package net.betterspears.enchantment;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.ProjectileDamageSource;
import org.jetbrains.annotations.Nullable;

public class SpearDamageSource {
    public static DamageSource spear(Entity spear, @Nullable Entity attacker) {
        return (new ProjectileDamageSource("spear", spear, attacker)).setProjectile();
    }
}
