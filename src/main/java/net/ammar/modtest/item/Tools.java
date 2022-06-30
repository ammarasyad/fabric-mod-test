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

    private int miningLevel;
    private int itemDurability;
    private float miningSpeed;
    private float attackDamage;
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

    public void setDurability(int itemDurability) {
        this.itemDurability = itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return miningSpeed;
    }

    public void setMiningSpeedMultiplier(float miningSpeed) {
        this.miningSpeed = miningSpeed;
    }

    public float getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(float attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public void setMiningLevel(int miningLevel) {
        this.miningLevel = miningLevel;
    }

    public int getEnchantability() {
        return enchantability;
    }

    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}
