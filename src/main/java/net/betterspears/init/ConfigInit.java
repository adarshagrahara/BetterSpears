package net.betterspears.init;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.betterspears.config.SpearsConfig;

public class ConfigInit {
  public static SpearsConfig CONFIG = new SpearsConfig();

  public static void init() {
    AutoConfig.register(SpearsConfig.class, JanksonConfigSerializer::new);
    CONFIG = AutoConfig.getConfigHolder(SpearsConfig.class).getConfig();
  }

}
