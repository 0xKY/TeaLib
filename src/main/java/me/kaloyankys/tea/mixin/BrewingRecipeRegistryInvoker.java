package me.kaloyankys.tea.mixin;

import me.kaloyankys.tea.util.EnhancedRegistry;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@SuppressWarnings("unused")
@Mixin(BrewingRecipeRegistry.class)
public interface BrewingRecipeRegistryInvoker {

    /**
     * Allows for access to the method, registerPotionRecipe
     * which is used for registering potion recipes in {@link EnhancedRegistry}
     */
    @Invoker("registerPotionRecipe")
    static void registerPotionRecipe(Potion input, Item item, Potion output) {
        throw new IllegalStateException("This should not happen");
    }
}
