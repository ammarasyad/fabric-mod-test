package net.ammar.modtest.item;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class CopperSword extends SwordItem {

    public CopperSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
