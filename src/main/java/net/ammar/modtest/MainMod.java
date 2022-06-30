package net.ammar.modtest;

import net.ammar.modtest.item.CopperPickaxe;
import net.ammar.modtest.item.CopperSword;
import net.ammar.modtest.item.Tools;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("ammar");

	// Copper Tools
	public static ToolItem CopperPickaxe = new CopperPickaxe(Tools.COPPER, 1, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem CopperSword = new CopperSword(Tools.COPPER, 5, -2.5F, new Item.Settings().group(ItemGroup.COMBAT));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ITEM, new Identifier("ammar", "copper_pickaxe"), CopperPickaxe);
        Registry.register(Registry.ITEM, new Identifier("ammar", "copper_sword"), CopperSword);
        AttackBlockCallback.EVENT.register(((player, world, hand, pos, direction) -> {
            if (!player.isSpectator()) {
                // This is such a crappy method, might be changed if I find a better approach
                if (player.getMainHandStack().isItemEqual(CopperPickaxe.getDefaultStack()) && player.getOffHandStack().isItemEqual(Items.REDSTONE_TORCH.getDefaultStack())) {
                    player.getMainHandStack().addEnchantment(Enchantments.EFFICIENCY, 3);
                } else if (player.getMainHandStack().isItemEqual(CopperPickaxe.getDefaultStack()) && !player.getOffHandStack().isItemEqual(Items.REDSTONE_TORCH.getDefaultStack())) {
                    player.getMainHandStack().removeSubNbt("Enchantments");
                }
            }
            return ActionResult.PASS;
        }));
	}
}
