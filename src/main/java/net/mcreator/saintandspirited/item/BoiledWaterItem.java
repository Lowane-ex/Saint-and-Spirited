
package net.mcreator.saintandspirited.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.saintandspirited.procedures.BoiledWaterFoodEatenProcedure;
import net.mcreator.saintandspirited.itemgroup.SaintandSpiritedItemGroup;
import net.mcreator.saintandspirited.SaintAndSpiritedModElements;

import java.util.Map;
import java.util.HashMap;

@SaintAndSpiritedModElements.ModElement.Tag
public class BoiledWaterItem extends SaintAndSpiritedModElements.ModElement {
	@ObjectHolder("saint_and_spirited:boiled_water")
	public static final Item block = null;
	public BoiledWaterItem(SaintAndSpiritedModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(SaintandSpiritedItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(0).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("boiled_water");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				BoiledWaterFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
