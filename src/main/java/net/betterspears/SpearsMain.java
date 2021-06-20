package net.betterspears;

import net.betterspears.init.*;
import net.betterspears.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class SpearsMain implements ModInitializer {
  public static final String MOD_ID = "betterspears";


  @Override
  public void onInitialize() {

    ModItems.registerItems();
    ConfigInit.init();
    EntityInit.init();
    ItemInit.init();
    ParticleInit.init();
    SoundInit.init();
    TagInit.init();


  }

}

// You are LOVED!!!
// Jesus loves you unconditionally!