package net.ammar.modtest.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum Tools implements ToolMaterial {
    COPPER(1, 193, 4.0F, 1.0F, 14, () -> {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    Tools(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient){
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    public int getDurability() {
        return itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return miningSpeed;
    }

    public float getAttackDamage() {
        return attackDamage;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public int getEnchantability() {
        return enchantability;
    }

    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}
