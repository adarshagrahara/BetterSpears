package net.betterspears.init;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoundInit {

    public static final Identifier MAGIC_HEAL_AURA = new Identifier("betterspears:magic_heal_aura");
    public static final Identifier MAGIC_SHOT = new Identifier("betterspears:magic_shot");
    public static final Identifier PARRYING = new Identifier("betterspears:parrying");
    public static final Identifier SWORD_PARRYING = new Identifier("betterspears:sword_parrying");
    public static SoundEvent SWORD_PARRYING_EVENT = new SoundEvent(SWORD_PARRYING);
    public static SoundEvent MAGIC_HEAL_AURA_EVENT = new SoundEvent(MAGIC_HEAL_AURA);
    public static SoundEvent MAGIC_SHOT_EVENT = new SoundEvent(MAGIC_SHOT);
    public static SoundEvent PARRYING_EVENT = new SoundEvent(PARRYING);

    public static void init() {
        Registry.register(Registry.SOUND_EVENT, SoundInit.MAGIC_HEAL_AURA, MAGIC_HEAL_AURA_EVENT);
        Registry.register(Registry.SOUND_EVENT, SoundInit.MAGIC_SHOT, MAGIC_SHOT_EVENT);
        Registry.register(Registry.SOUND_EVENT, SoundInit.PARRYING, PARRYING_EVENT);
        Registry.register(Registry.SOUND_EVENT, SoundInit.SWORD_PARRYING, SWORD_PARRYING_EVENT);
    }

}
