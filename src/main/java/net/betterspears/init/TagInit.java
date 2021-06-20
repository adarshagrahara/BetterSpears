package net.betterspears.init;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class TagInit {

  public static final Tag<Item> DOUBLE_HANDED_ITEMS = TagRegistry
      .item(new Identifier("betterspears", "double_handed_items"));
  public static final Tag<Item> ACCROSS_DOUBLE_HANDED_ITEMS = TagRegistry
      .item(new Identifier("betterspears", "accross_double_handed_items"));
  public static final Tag<Item> SPEAR = TagRegistry
          .item(new Identifier("betterspears", "spear"));

  public static void init() {
  }

}
