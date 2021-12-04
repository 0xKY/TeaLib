package me.kaloyankys.tea.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class TeaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
    }

    public static <T extends ParticleEffect> void particle(ParticleType<T> particleType, ParticleFactory<T> factory) {
        ParticleFactoryRegistry.getInstance().register(particleType, factory);
    }
}
