package net.mcreator.saintandspirited.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.saintandspirited.item.Holyrelic4Item;
import net.mcreator.saintandspirited.item.Holyrelic3Item;
import net.mcreator.saintandspirited.item.Holyrelic2Item;
import net.mcreator.saintandspirited.item.HolyRelicsItem;
import net.mcreator.saintandspirited.SaintAndSpiritedModElements;
import net.mcreator.saintandspirited.SaintAndSpiritedMod;

import java.util.Map;
import java.util.HashMap;

@SaintAndSpiritedModElements.ModElement.Tag
public class HolyRelicsItemInInventoryTickProcedure extends SaintAndSpiritedModElements.ModElement {
	public HolyRelicsItemInInventoryTickProcedure(SaintAndSpiritedModElements instance) {
		super(instance, 2);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaintAndSpiritedMod.LOGGER.warn("Failed to load dependency entity for procedure HolyRelicsItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(HolyRelicsItem.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 100, (int) 0));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Holyrelic3Item.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 100, (int) 0));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Holyrelic4Item.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 100, (int) 0));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Holyrelic2Item.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 100, (int) 0));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
