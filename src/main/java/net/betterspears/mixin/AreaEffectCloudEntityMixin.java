package net.betterspears.mixin;

import net.betterspears.init.ParticleInit;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.List;

@Mixin(AreaEffectCloudEntity.class)
public abstract class AreaEffectCloudEntityMixin {
    @Shadow
    private LivingEntity owner;

    @Inject(method = "Lnet/minecraft/entity/AreaEffectCloudEntity;tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/effect/StatusEffect;applyInstantEffect(Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/LivingEntity;ID)V"), cancellable = true, locals = LocalCapture.CAPTURE_FAILSOFT)
    private void tickMixin(CallbackInfo info, boolean bl, float f, List<StatusEffectInstance> list,
            List<LivingEntity> list2, Iterator<LivingEntity> var6, LivingEntity livingEntity) {
        if (livingEntity.equals(owner) && getParticleType().equals(ParticleInit.HEALING_AURA_PARTICLE)) {
            info.cancel();
        }
    }

    @Shadow
    public ParticleEffect getParticleType() {
        return null;
    }

}
