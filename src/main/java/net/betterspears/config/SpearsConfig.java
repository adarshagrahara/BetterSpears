package net.betterspears.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "betterspears")
@Config.Gui.Background("minecraft:textures/block/stone.png")
public class SpearsConfig implements ConfigData {
  @ConfigEntry.Gui.PrefixText
  public boolean auto_switch = false;

}
