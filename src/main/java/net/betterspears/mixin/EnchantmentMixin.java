package net.betterspears.mixin;

import net.betterspears.entity.Spear_Entity;
import net.betterspears.item.Spear_Item;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    private void isAcceptableItemMixin(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
        if (((Object) this == Enchantments.PIERCING || (Object) this == Enchantments.KNOCKBACK
                 ||(Object) this == Enchantments.LOYALTY ||(Object) this == Enchantments.FLAME||(Object) this == Enchantments.FIRE_ASPECT
                 ||(Object) this == Enchantments.PUNCH) && stack.getItem() instanceof Spear_Item){

            info.setReturnValue(true);
        }

    }
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    private void isAcceptableEntityMixin(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
        if (((Object) this == Enchantments.PIERCING || (Object) this == Enchantments.KNOCKBACK
                ||(Object) this == Enchantments.LOYALTY||(Object) this == Enchantments.FIRE_ASPECT
                || (Object) this == Enchantments.FLAME ||(Object) this == Enchantments.PUNCH) && stack.getHolder() instanceof Spear_Entity){

            info.setReturnValue(true);
        }

    }


    }

    abstract class EnchantmentHelperMixen{

}

