package net.betterspears.init;

import net.betterspears.entity.renderer.Spear_Entity_Renderer;
import net.betterspears.init.ParticleInit.HealingAuraParticle;
import net.betterspears.network.EntitySpawnPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class RenderInit {

        public static void init() {
                // Packet
                ClientPlayNetworking.registerGlobalReceiver(EntitySpawnPacket.ID, EntitySpawnPacket::onPacket);

                EntityRendererRegistry.INSTANCE.register(EntityInit.WOODEN_SPEAR,
                                (dispatcher, context) -> new Spear_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.STONE_SPEAR,
                                (dispatcher, context) -> new Spear_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.IRON_SPEAR,
                                (dispatcher, context) -> new Spear_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_SPEAR,
                                (dispatcher, context) -> new Spear_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.DIAMOND_SPEAR,
                                (dispatcher, context) -> new Spear_Entity_Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(EntityInit.NETHERITE_SPEAR,
                                (dispatcher, context) -> new Spear_Entity_Renderer(dispatcher));

                ParticleFactoryRegistry.getInstance().register(ParticleInit.HEALING_AURA_PARTICLE,
                                HealingAuraParticle.Factory::new);

        }

}