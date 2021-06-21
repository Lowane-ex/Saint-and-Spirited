package net.mcreator.saintandspirited.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.potion.Effects;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.saintandspirited.SaintAndSpiritedModElements;
import net.mcreator.saintandspirited.SaintAndSpiritedMod;

import java.util.Map;

@SaintAndSpiritedModElements.ModElement.Tag
public class HolyWaterFoodEatenProcedure extends SaintAndSpiritedModElements.ModElement {
	public HolyWaterFoodEatenProcedure(SaintAndSpiritedModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaintAndSpiritedMod.LOGGER.warn("Failed to load dependency entity for procedure HolyWaterFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.WEAKNESS);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.WITHER);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.POISON);
		}
	}
}
