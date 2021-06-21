package net.mcreator.saintandspirited.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.saintandspirited.SaintAndSpiritedModElements;
import net.mcreator.saintandspirited.SaintAndSpiritedMod;

import java.util.Map;

@SaintAndSpiritedModElements.ModElement.Tag
public class BoiledWaterFoodEatenProcedure extends SaintAndSpiritedModElements.ModElement {
	public BoiledWaterFoodEatenProcedure(SaintAndSpiritedModElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaintAndSpiritedMod.LOGGER.warn("Failed to load dependency entity for procedure BoiledWaterFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double diamonds = 0;
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
