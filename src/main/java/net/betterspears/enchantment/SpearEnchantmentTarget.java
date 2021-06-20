//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.betterspears.enchantment;

import net.betterspears.item.Spear_Item;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;

public enum SpearEnchantmentTarget {

    SPEAR {
        public boolean isAcceptableItem(Item item) {
            return item instanceof Spear_Item;
        }
    };

    private SpearEnchantmentTarget() {
    }

    public abstract boolean isAcceptableItem(Item item);
}
