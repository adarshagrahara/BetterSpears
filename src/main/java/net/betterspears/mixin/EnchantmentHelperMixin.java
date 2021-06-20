package net.betterspears.mixin;

import net.betterspears.init.TagInit;
import net.betterspears.item.Spear_Item;
import net.minecraft.enchantment.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
  @Inject(method = "Lnet/minecraft/enchantment/EnchantmentHelper;getSweepingMultiplier(Lnet/minecraft/entity/LivingEntity;)F", at = @At(value = "HEAD"), cancellable = true)
  private static void getSweepingMultiplierMixin(LivingEntity entity, CallbackInfoReturnable<Float> info) {
    if (entity.getMainHandStack().getItem().isIn(TagInit.SPEAR)) {
      int lvl = getEquipmentLevel(Enchantments.LOYALTY, entity);
      info.setReturnValue(lvl + 1.0F);
    }
    if (entity.getMainHandStack().getItem().isIn(TagInit.SPEAR)) {
      int lvl = getEquipmentLevel(Enchantments.PIERCING, entity);
      info.setReturnValue(lvl + 1.0F);
    }
    if (entity.getMainHandStack().getItem().isIn(TagInit.SPEAR)) {
      int lvl = getEquipmentLevel(Enchantments.FLAME, entity);
      info.setReturnValue(lvl + 1.0F);
    }
    if (entity.getMainHandStack().getItem().isIn(TagInit.SPEAR)) {
      int lvl = getEquipmentLevel(Enchantments.KNOCKBACK, entity);
      info.setReturnValue(lvl + 1.0F);
    }
    if (entity.getMainHandStack().getItem().isIn(TagInit.SPEAR)) {
      int lvl = getEquipmentLevel(Enchantments.PUNCH, entity);
      info.setReturnValue(lvl + 1.0F);
    }

  }

  @Inject(method = "getPossibleEntries(ILnet/minecraft/item/ItemStack;Z)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
  private static void getPossibleEntriesMixin(int i, ItemStack stack, boolean treasureAllowed,
      CallbackInfoReturnable<List<EnchantmentLevelEntry>> info) {
    if (stack.getItem() instanceof Spear_Item) {
      List<EnchantmentLevelEntry> currentEnchantments = info.getReturnValue();
      List<EnchantmentLevelEntry> enchantments = new ArrayList<>();
      currentEnchantments.forEach(enchantment -> {
        if (!(enchantment.enchantment.type == EnchantmentTarget.TRIDENT)
            || enchantment.enchantment == Enchantments.LOYALTY) {
          enchantments.add(enchantment);
        }
      });
      Enchantment piercing = Enchantments.PIERCING;
      for (int level = piercing.getMaxLevel(); level > piercing.getMinLevel() - 1; --level) {
        if (i >= piercing.getMinPower(level) && i <= piercing.getMaxPower(level)) {
          enchantments.add(new EnchantmentLevelEntry(piercing, level));
          break;
        }
      }
      Enchantment flame = Enchantments.FLAME;
      for (int level = flame.getMaxLevel(); level > flame.getMinLevel() - 1; --level) {
        if (i >= flame.getMinPower(level) && i <= flame.getMaxPower(level)) {
          enchantments.add(new EnchantmentLevelEntry(flame, level));
          break;
        }
      }
      Enchantment loyalty = Enchantments.LOYALTY;
      for (int level = loyalty.getMaxLevel(); level > loyalty.getMinLevel() - 1; --level) {
        if (i >= loyalty.getMinPower(level) && i <= loyalty.getMaxPower(level)) {
          enchantments.add(new EnchantmentLevelEntry(loyalty, level));
          break;
        }
      }
      Enchantment mending = Enchantments.MENDING;
      for (int level = mending.getMaxLevel(); level > mending.getMinLevel() - 1; --level) {
        if (i >= mending.getMinPower(level) && i <= mending.getMaxPower(level)) {
          enchantments.add(new EnchantmentLevelEntry(mending, level));
          break;
        }
      }
      Enchantment unbreaking = Enchantments.UNBREAKING;
      for (int level = unbreaking.getMaxLevel(); level > unbreaking.getMinLevel() - 1; --level) {
        if (i >= unbreaking.getMinPower(level) && i <= unbreaking.getMaxPower(level)) {
          enchantments.add(new EnchantmentLevelEntry(unbreaking, level));
          break;
        }
      }
      Enchantment knockback = Enchantments.KNOCKBACK;
      for (int level = knockback.getMaxLevel(); level > knockback.getMinLevel() - 1; --level) {
        if (i >= knockback.getMinPower(level) && i <= knockback.getMaxPower(level)) {
          enchantments.add(new EnchantmentLevelEntry(knockback, level));
          break;
        }
      }
      Enchantment punch = Enchantments.PUNCH;
      for (int level = punch.getMaxLevel(); level > punch.getMinLevel() - 1; --level) {
        if (i >= punch.getMinPower(level) && i <= punch.getMaxPower(level)) {
          enchantments.add(new EnchantmentLevelEntry(punch, level));
          break;
        }
      }



      info.setReturnValue(enchantments);
    }
  }



  @Shadow
  public static int getEquipmentLevel(Enchantment enchantment, LivingEntity entity) {
    return 1;
  }

}
