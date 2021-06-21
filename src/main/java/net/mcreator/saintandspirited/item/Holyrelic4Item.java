
package net.mcreator.saintandspirited.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.saintandspirited.procedures.HolyRelicsItemInInventoryTickProcedure;
import net.mcreator.saintandspirited.itemgroup.SaintandSpiritedItemGroup;
import net.mcreator.saintandspirited.SaintAndSpiritedModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@SaintAndSpiritedModElements.ModElement.Tag
public class Holyrelic4Item extends SaintAndSpiritedModElements.ModElement {
	@ObjectHolder("saint_and_spirited:holyrelic_4")
	public static final Item block = null;
	public Holyrelic4Item(SaintAndSpiritedModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SaintandSpiritedItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
			setRegistryName("holyrelic_4");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("You feel cared for"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				HolyRelicsItemInInventoryTickProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
