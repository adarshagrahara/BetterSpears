package net.betterspears.init;

import net.betterspears.item.Spear_Item;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemInit {
        
        // Map
        private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();


        public static final Spear_Item WOODEN_SPEAR_ITEM = register("wooden_spear",
                        new Spear_Item(ToolMaterials.WOOD, 2.2F, -2.2F, () -> EntityInit.WOODEN_SPEAR,
                                        new Item.Settings().group(ItemGroup.COMBAT)));
        public static final Spear_Item STONE_SPEAR_ITEM = register("stone_spear",
                        new Spear_Item(ToolMaterials.STONE, 2.2F, -2.2F, () -> EntityInit.STONE_SPEAR,
                                        new Item.Settings().group(ItemGroup.COMBAT)));
        public static final Spear_Item IRON_SPEAR_ITEM = register("iron_spear",
                        new Spear_Item(ToolMaterials.IRON, 2.2F, -2.2F, () -> EntityInit.IRON_SPEAR,
                                        new Item.Settings().group(ItemGroup.COMBAT)));
        public static final Spear_Item GOLDEN_SPEAR_ITEM = register("golden_spear",
                        new Spear_Item(ToolMaterials.GOLD, 2.2F, -2.2F, () -> EntityInit.GOLDEN_SPEAR,
                                        new Item.Settings().group(ItemGroup.COMBAT)));
        public static final Spear_Item DIAMOND_SPEAR_ITEM = register("diamond_spear",
                        new Spear_Item(ToolMaterials.DIAMOND, 2.2F, -2.2F, () -> EntityInit.DIAMOND_SPEAR,
                                        new Item.Settings().group(ItemGroup.COMBAT)));
        public static final Spear_Item NETHERITE_SPEAR_ITEM = register("netherite_spear",
                        new Spear_Item(ToolMaterials.NETHERITE, 2.2F, -2.2F, () -> EntityInit.NETHERITE_SPEAR,
                                        new Item.Settings().group(ItemGroup.COMBAT).fireproof()));


        private static <I extends Item> I register(String name, I item) {
                ITEMS.put(new Identifier("betterspears", name), item);
                return item;
        }

        public static void init() {
                for (Identifier id : ITEMS.keySet()) {
                        Registry.register(Registry.ITEM, id, ITEMS.get(id));
                }
        }

}
