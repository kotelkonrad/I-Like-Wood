package yamahari.ilikewood.util;

import com.google.common.collect.ImmutableMap;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import yamahari.ilikewood.config.ILikeWoodConfig;
import yamahari.ilikewood.tier.WoodenItemTier;

public class WoodenItemTiers {
    public static final WoodenItemTier ACACIA = new WoodenItemTier(
            "acacia",
            ILikeWoodConfig.COMMON_CONFIG.ACACIA_HARVEST_LEVEL.get(),
            ILikeWoodConfig.COMMON_CONFIG.ACACIA_MAX_USES.get(),
            ILikeWoodConfig.COMMON_CONFIG.ACACIA_EFFICIENCY.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.ACACIA_ATTACK_DAMAGE.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.ACACIA_ENCHANTABILITY.get(),
            () -> Ingredient.fromItems(Items.ACACIA_PLANKS),
            ImmutableMap.of(
                    TieredItemType.AXE, 
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_AXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_AXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.HOE, 
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_HOE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_HOE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.PICKAXE, 
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_PICKAXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_PICKAXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SHOVEL, 
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_SHOVEL_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_SHOVEL_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SWORD, 
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_SWORD_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_SWORD_ATTACK_DAMAGE.get().floatValue()
                    )
            )
    );

    public static final WoodenItemTier BIRCH = new WoodenItemTier(
            "birch",
            ILikeWoodConfig.COMMON_CONFIG.BIRCH_HARVEST_LEVEL.get(),
            ILikeWoodConfig.COMMON_CONFIG.BIRCH_MAX_USES.get(),
            ILikeWoodConfig.COMMON_CONFIG.BIRCH_EFFICIENCY.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.BIRCH_ATTACK_DAMAGE.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.BIRCH_ENCHANTABILITY.get(),
            () -> Ingredient.fromItems(Items.BIRCH_PLANKS),
            ImmutableMap.of(
                    TieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_AXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_AXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_HOE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_HOE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_PICKAXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_PICKAXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_SHOVEL_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_SHOVEL_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_SWORD_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_SWORD_ATTACK_DAMAGE.get().floatValue()
                    )
            )
    );

    public static final WoodenItemTier DARK_OAK = new WoodenItemTier(
            "dark_oak",
            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_HARVEST_LEVEL.get(),
            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_MAX_USES.get(),
            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_EFFICIENCY.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_ATTACK_DAMAGE.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_ENCHANTABILITY.get(),
            () -> Ingredient.fromItems(Items.DARK_OAK_PLANKS),
            ImmutableMap.of(
                    TieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_AXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_AXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_HOE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_HOE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_PICKAXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_PICKAXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_SHOVEL_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_SHOVEL_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_SWORD_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_SWORD_ATTACK_DAMAGE.get().floatValue()
                    )
            )
    );

    public static final WoodenItemTier JUNGLE = new WoodenItemTier(
            "jungle",
            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_HARVEST_LEVEL.get(),
            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_MAX_USES.get(),
            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_EFFICIENCY.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_ATTACK_DAMAGE.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_ENCHANTABILITY.get(),
            () -> Ingredient.fromItems(Items.JUNGLE_PLANKS),
            ImmutableMap.of(
                    TieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_AXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_AXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_HOE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_HOE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_PICKAXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_PICKAXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_SHOVEL_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_SHOVEL_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_SWORD_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_SWORD_ATTACK_DAMAGE.get().floatValue()
                    )
            )
    );

    public static final WoodenItemTier OAK = new WoodenItemTier(
            "oak",
            ILikeWoodConfig.COMMON_CONFIG.OAK_HARVEST_LEVEL.get(),
            ILikeWoodConfig.COMMON_CONFIG.OAK_MAX_USES.get(),
            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_EFFICIENCY.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.OAK_ATTACK_DAMAGE.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.OAK_ENCHANTABILITY.get(),
            () -> Ingredient.fromItems(Items.OAK_PLANKS),
            ImmutableMap.of(
                    TieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.OAK_AXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.OAK_AXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.OAK_HOE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.OAK_HOE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.OAK_PICKAXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.OAK_PICKAXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.OAK_SHOVEL_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.OAK_SHOVEL_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.OAK_SWORD_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.OAK_SWORD_ATTACK_DAMAGE.get().floatValue()
                    )
            )
    );

    public static final WoodenItemTier SPRUCE = new WoodenItemTier(
            "spruce",
            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_HARVEST_LEVEL.get(),
            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_MAX_USES.get(),
            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_EFFICIENCY.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_ATTACK_DAMAGE.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_ENCHANTABILITY.get(),
            () -> Ingredient.fromItems(Items.SPRUCE_PLANKS),
            ImmutableMap.of(
                    TieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_AXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_AXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_HOE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_HOE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_PICKAXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_PICKAXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_SHOVEL_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_SHOVEL_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_SWORD_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_SWORD_ATTACK_DAMAGE.get().floatValue()
                    )
            )
    );

    public static final WoodenItemTier STONE = new WoodenItemTier(
            "stone",
            ILikeWoodConfig.COMMON_CONFIG.STONE_HARVEST_LEVEL.get(),
            ILikeWoodConfig.COMMON_CONFIG.STONE_MAX_USES.get(),
            ILikeWoodConfig.COMMON_CONFIG.STONE_EFFICIENCY.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.STONE_ATTACK_DAMAGE.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.STONE_ENCHANTABILITY.get(),
            () -> Ingredient.fromItems(Items.COBBLESTONE),
            ImmutableMap.of(
                    TieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.STONE_AXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.STONE_AXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.STONE_HOE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.STONE_HOE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.STONE_PICKAXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.STONE_PICKAXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.STONE_SHOVEL_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.STONE_SHOVEL_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.STONE_SWORD_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.STONE_SWORD_ATTACK_DAMAGE.get().floatValue()
                    )
            )
    );

    public static final WoodenItemTier IRON = new WoodenItemTier(
            "iron",
            ILikeWoodConfig.COMMON_CONFIG.IRON_HARVEST_LEVEL.get(),
            ILikeWoodConfig.COMMON_CONFIG.IRON_MAX_USES.get(),
            ILikeWoodConfig.COMMON_CONFIG.IRON_EFFICIENCY.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.IRON_ATTACK_DAMAGE.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.IRON_ENCHANTABILITY.get(),
            () -> Ingredient.fromItems(Items.IRON_INGOT),
            ImmutableMap.of(
                    TieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.IRON_AXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.IRON_AXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.IRON_HOE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.IRON_HOE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.IRON_PICKAXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.IRON_PICKAXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.IRON_SHOVEL_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.IRON_SHOVEL_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.IRON_SWORD_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.IRON_SWORD_ATTACK_DAMAGE.get().floatValue()
                    )
            )
    );

    public static final WoodenItemTier DIAMOND = new WoodenItemTier(
            "diamond",
            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_HARVEST_LEVEL.get(),
            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_MAX_USES.get(),
            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_EFFICIENCY.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_ATTACK_DAMAGE.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_ENCHANTABILITY.get(),
            () -> Ingredient.fromItems(Items.DIAMOND),
            ImmutableMap.of(
                    TieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_AXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_AXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_HOE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_HOE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_PICKAXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_PICKAXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_SHOVEL_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_SHOVEL_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_SWORD_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.DIAMOND_SWORD_ATTACK_DAMAGE.get().floatValue()
                    )
            )
    );

    public static final WoodenItemTier GOLD = new WoodenItemTier(
            "golden",
            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_HARVEST_LEVEL.get(),
            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_MAX_USES.get(),
            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_EFFICIENCY.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_ATTACK_DAMAGE.get().floatValue(),
            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_ENCHANTABILITY.get(),
            () -> Ingredient.fromItems(Items.GOLD_INGOT),
            ImmutableMap.of(
                    TieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_AXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_AXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_HOE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_HOE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_PICKAXE_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_PICKAXE_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_SHOVEL_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_SHOVEL_ATTACK_DAMAGE.get().floatValue()
                    ),
                    TieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_SWORD_ATTACK_SPEED.get().floatValue(),
                            ILikeWoodConfig.COMMON_CONFIG.GOLDEN_SWORD_ATTACK_DAMAGE.get().floatValue()
                    )
            )
    );
}
