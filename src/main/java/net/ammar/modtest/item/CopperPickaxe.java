package net.ammar.modtest.item;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class CopperPickaxe extends PickaxeItem {

    public CopperPickaxe(ToolMaterial material, int attackDamage, float miningSpeed, Settings settings) {
        super(material, attackDamage, miningSpeed, settings);
    }
}
