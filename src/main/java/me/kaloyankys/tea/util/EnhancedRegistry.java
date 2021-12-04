package me.kaloyankys.tea.util;

import me.kaloyankys.tea.client.TeaClient;
import me.kaloyankys.tea.mixin.BrewingRecipeRegistryInvoker;
import me.kaloyankys.tea.vanilla.TParticleType;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.particle.DefaultParticleType;

public class EnhancedRegistry {
    /**
     *
     * @param id The id of the potion
     * @param modId The modid of the mod using TeaLib
     * @param effect The effect of the potion
     * @param baseToBrewFrom The base potion used to brew the custom potion (Awkward potion, Water Bottle etc.)
     * @param ingredient The ingredient used to brew the potion
     * @param duration The duration of the effect
     * @param amplifier The amplifier of the effect
     * @param ambient If the effect is ambient or not
     * @param visible If the effect is visible or not
     * {@link BrewingRecipeRegistryInvoker} is used here to register a recipe for the custom potion
     */

    public static void registerPotion(String id, String modId, StatusEffect effect, Potion baseToBrewFrom, Item ingredient, int duration, int amplifier, boolean ambient, boolean visible) {
        Potion potion = new Potion(id, new StatusEffectInstance(effect, duration, amplifier, ambient, visible));
        Registry.register(Registry.POTION, new Identifier(modId, id), potion);
        BrewingRecipeRegistryInvoker.registerPotionRecipe(baseToBrewFrom, ingredient, potion);
    }

    /**
     *
     * @param id The id of the potion
     * @param modId The modid of the mod using TeaLib
     * @param alwaysShow alwaysShow parameter of {@link DefaultParticleType}
     * @param factory The particle factory
     * @param <T> The type parameter required by {@link ParticleFactoryRegistry}
     */

    public static <T extends ParticleEffect> void registerParticle(String id, String modId, boolean alwaysShow, ParticleFactory<T> factory) {
        ParticleType<T> particleType = (ParticleType<T>) new TParticleType(alwaysShow);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(modId, id), particleType);
        TeaClient.particle(particleType, factory);
    }
}
