package net.betterspears.init;

import net.betterspears.entity.Spear_Entity;
import net.betterspears.item.Spear_Item;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class EntityInit {
        // Map
        private static final Map<Identifier, EntityType<?>> ENTITY_TYPES = new LinkedHashMap<>();
        public static final EntityType<Spear_Entity> WOODEN_SPEAR = register("wooden_spear",
                        create_Spear(ItemInit.WOODEN_SPEAR_ITEM));
        public static final EntityType<Spear_Entity> STONE_SPEAR = register("stone_spear",
                        create_Spear(ItemInit.STONE_SPEAR_ITEM));
        public static final EntityType<Spear_Entity> IRON_SPEAR = register("iron_spear",
                        create_Spear(ItemInit.IRON_SPEAR_ITEM));
        public static final EntityType<Spear_Entity> GOLDEN_SPEAR = register("golden_spear",
                        create_Spear(ItemInit.GOLDEN_SPEAR_ITEM));
        public static final EntityType<Spear_Entity> DIAMOND_SPEAR = register("diamond_spear",
                        create_Spear(ItemInit.DIAMOND_SPEAR_ITEM));
        public static final EntityType<Spear_Entity> NETHERITE_SPEAR = register("netherite_spear",
                        create_Spear(ItemInit.NETHERITE_SPEAR_ITEM));

        public static void init() {
                for (Identifier id : ENTITY_TYPES.keySet()) {
                        Registry.register(Registry.ENTITY_TYPE, id, ENTITY_TYPES.get(id));
                }
        }

        private static <T extends EntityType<?>> T register(String name, T type) {
                Identifier id = new Identifier("betterspears", name);
                ENTITY_TYPES.put(id, type);
                return type;
        }





        private static EntityType<Spear_Entity> create_Spear(Spear_Item item) {
                return FabricEntityTypeBuilder
                                .<Spear_Entity>create(SpawnGroup.MISC,
                                                (entity, world) -> new Spear_Entity(entity, world, item))
                                .dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build();
        }

}