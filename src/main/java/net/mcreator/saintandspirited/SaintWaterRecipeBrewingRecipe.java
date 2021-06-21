
package net.mcreator.saintandspirited;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.saintandspirited.item.HolyWaterItem;
import net.mcreator.saintandspirited.item.BoiledWaterItem;

@SaintAndSpiritedModElements.ModElement.Tag
public class SaintWaterRecipeBrewingRecipe extends SaintAndSpiritedModElements.ModElement {
	public SaintWaterRecipeBrewingRecipe(SaintAndSpiritedModElements instance) {
		super(instance, 20);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(BoiledWaterItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Items.GOLD_INGOT, (int) (1))), new ItemStack(HolyWaterItem.block, (int) (1)));
	}
}
