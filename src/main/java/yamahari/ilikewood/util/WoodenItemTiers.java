package yamahari.ilikewood.util;

import com.google.common.collect.ImmutableMap;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import yamahari.ilikewood.config.ILikeWoodConfig;
import yamahari.ilikewood.objectholders.panels.WoodenPanelsItems;
import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.tier.WoodenTieredItemType;

public class WoodenItemTiers {
    public static final WoodenItemTier ACACIA = new WoodenItemTier(
            WoodTypes.ACACIA.getName(),
            true,
            ILikeWoodConfig.SERVER_CONFIG.ACACIA_HARVEST_LEVEL::get,
            ILikeWoodConfig.SERVER_CONFIG.ACACIA_MAX_USES::get,
            ILikeWoodConfig.SERVER_CONFIG.ACACIA_EFFICIENCY::get,
            ILikeWoodConfig.SERVER_CONFIG.ACACIA_ATTACK_DAMAGE::get,
            ILikeWoodConfig.SERVER_CONFIG.ACACIA_ENCHANTABILITY::get,
            () -> Ingredient.fromItems(WoodenPanelsItems.ACACIA),
            ImmutableMap.of(
                    WoodenTieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_AXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_AXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_AXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_HOE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_HOE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_HOE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_PICKAXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_PICKAXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_PICKAXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_SHOVEL_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_SHOVEL_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_SHOVEL_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_SWORD_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_SWORD_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.ACACIA_SWORD_BURN_TIME::get
                    )
            )
    );

    public static final WoodenItemTier BIRCH = new WoodenItemTier(
            WoodTypes.BIRCH.getName(),
            true,
            ILikeWoodConfig.SERVER_CONFIG.BIRCH_HARVEST_LEVEL::get,
            ILikeWoodConfig.SERVER_CONFIG.BIRCH_MAX_USES::get,
            ILikeWoodConfig.SERVER_CONFIG.BIRCH_EFFICIENCY::get,
            ILikeWoodConfig.SERVER_CONFIG.BIRCH_ATTACK_DAMAGE::get,
            ILikeWoodConfig.SERVER_CONFIG.BIRCH_ENCHANTABILITY::get,
            () -> Ingredient.fromItems(WoodenPanelsItems.BIRCH),
            ImmutableMap.of(
                    WoodenTieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_AXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_AXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_AXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_HOE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_HOE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_HOE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_PICKAXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_PICKAXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_PICKAXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_SHOVEL_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_SHOVEL_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_SHOVEL_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_SWORD_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_SWORD_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.BIRCH_SWORD_BURN_TIME::get
                    )
            )
    );

    public static final WoodenItemTier DARK_OAK = new WoodenItemTier(
            WoodTypes.DARK_OAK.getName(),
            true,
            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_HARVEST_LEVEL::get,
            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_MAX_USES::get,
            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_EFFICIENCY::get,
            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_ATTACK_DAMAGE::get,
            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_ENCHANTABILITY::get,
            () -> Ingredient.fromItems(WoodenPanelsItems.DARK_OAK),
            ImmutableMap.of(
                    WoodenTieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_AXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_AXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_AXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_HOE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_HOE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_HOE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_PICKAXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_PICKAXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_PICKAXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_SHOVEL_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_SHOVEL_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_SHOVEL_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_SWORD_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_SWORD_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_SWORD_BURN_TIME::get
                    )
            )
    );

    public static final WoodenItemTier JUNGLE = new WoodenItemTier(
            WoodTypes.JUNGLE.getName(),
            true,
            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_HARVEST_LEVEL::get,
            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_MAX_USES::get,
            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_EFFICIENCY::get,
            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_ATTACK_DAMAGE::get,
            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_ENCHANTABILITY::get,
            () -> Ingredient.fromItems(WoodenPanelsItems.JUNGLE),
            ImmutableMap.of(
                    WoodenTieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_AXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_AXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_AXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_HOE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_HOE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_HOE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_PICKAXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_PICKAXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_PICKAXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_SHOVEL_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_SHOVEL_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_SHOVEL_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_SWORD_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_SWORD_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_SWORD_BURN_TIME::get
                    )
            )
    );

    public static final WoodenItemTier OAK = new WoodenItemTier(
            WoodTypes.OAK.getName(),
            true,
            ILikeWoodConfig.SERVER_CONFIG.OAK_HARVEST_LEVEL::get,
            ILikeWoodConfig.SERVER_CONFIG.OAK_MAX_USES::get,
            ILikeWoodConfig.SERVER_CONFIG.OAK_EFFICIENCY::get,
            ILikeWoodConfig.SERVER_CONFIG.OAK_ATTACK_DAMAGE::get,
            ILikeWoodConfig.SERVER_CONFIG.OAK_ENCHANTABILITY::get,
            () -> Ingredient.fromItems(WoodenPanelsItems.OAK),
            ImmutableMap.of(
                    WoodenTieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.OAK_AXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.OAK_AXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.OAK_AXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.OAK_HOE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.OAK_HOE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.OAK_HOE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.OAK_PICKAXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.OAK_PICKAXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.OAK_PICKAXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.OAK_SHOVEL_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.OAK_SHOVEL_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.OAK_SHOVEL_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.OAK_SWORD_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.OAK_SWORD_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.OAK_SWORD_BURN_TIME::get
                    )
            )
    );

    public static final WoodenItemTier SPRUCE = new WoodenItemTier(
            WoodTypes.SPRUCE.getName(),
            true,
            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_HARVEST_LEVEL::get,
            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_MAX_USES::get,
            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_EFFICIENCY::get,
            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_ATTACK_DAMAGE::get,
            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_ENCHANTABILITY::get,
            () -> Ingredient.fromItems(WoodenPanelsItems.SPRUCE),
            ImmutableMap.of(
                    WoodenTieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_AXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_AXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_AXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_HOE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_HOE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_HOE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_PICKAXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_PICKAXE_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_PICKAXE_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_SHOVEL_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_SHOVEL_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_SHOVEL_BURN_TIME::get
                    ),
                    WoodenTieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_SWORD_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_SWORD_ATTACK_DAMAGE::get,
                            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_SWORD_BURN_TIME::get
                    )
            )
    );

    public static final WoodenItemTier STONE = new WoodenItemTier(
            "stone",
            false,
            ILikeWoodConfig.SERVER_CONFIG.STONE_HARVEST_LEVEL::get,
            ILikeWoodConfig.SERVER_CONFIG.STONE_MAX_USES::get,
            ILikeWoodConfig.SERVER_CONFIG.STONE_EFFICIENCY::get,
            ILikeWoodConfig.SERVER_CONFIG.STONE_ATTACK_DAMAGE::get,
            ILikeWoodConfig.SERVER_CONFIG.STONE_ENCHANTABILITY::get,
            () -> Ingredient.fromItems(Items.COBBLESTONE),
            ImmutableMap.of(
                    WoodenTieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.STONE_AXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.STONE_AXE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.STONE_HOE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.STONE_HOE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.STONE_PICKAXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.STONE_PICKAXE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.STONE_SHOVEL_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.STONE_SHOVEL_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.STONE_SWORD_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.STONE_SWORD_ATTACK_DAMAGE::get,
                            null
                    )
            )
    );

    public static final WoodenItemTier IRON = new WoodenItemTier(
            "iron",
            false,
            ILikeWoodConfig.SERVER_CONFIG.IRON_HARVEST_LEVEL::get,
            ILikeWoodConfig.SERVER_CONFIG.IRON_MAX_USES::get,
            ILikeWoodConfig.SERVER_CONFIG.IRON_EFFICIENCY::get,
            ILikeWoodConfig.SERVER_CONFIG.IRON_ATTACK_DAMAGE::get,
            ILikeWoodConfig.SERVER_CONFIG.IRON_ENCHANTABILITY::get,
            () -> Ingredient.fromItems(Items.IRON_INGOT),
            ImmutableMap.of(
                    WoodenTieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.IRON_AXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.IRON_AXE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.IRON_HOE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.IRON_HOE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.IRON_PICKAXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.IRON_PICKAXE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.IRON_SHOVEL_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.IRON_SHOVEL_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.IRON_SWORD_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.IRON_SWORD_ATTACK_DAMAGE::get,
                            null
                    )
            )
    );

    public static final WoodenItemTier DIAMOND = new WoodenItemTier(
            "diamond",
            false,
            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_HARVEST_LEVEL::get,
            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_MAX_USES::get,
            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_EFFICIENCY::get,
            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_ATTACK_DAMAGE::get,
            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_ENCHANTABILITY::get,
            () -> Ingredient.fromItems(Items.DIAMOND),
            ImmutableMap.of(
                    WoodenTieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_AXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_AXE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_HOE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_HOE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_PICKAXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_PICKAXE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_SHOVEL_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_SHOVEL_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_SWORD_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.DIAMOND_SWORD_ATTACK_DAMAGE::get,
                            null
                    )
            )
    );

    public static final WoodenItemTier GOLD = new WoodenItemTier(
            "golden",
            false,
            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_HARVEST_LEVEL::get,
            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_MAX_USES::get,
            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_EFFICIENCY::get,
            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_ATTACK_DAMAGE::get,
            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_ENCHANTABILITY::get,
            () -> Ingredient.fromItems(Items.GOLD_INGOT),
            ImmutableMap.of(
                    WoodenTieredItemType.AXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_AXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_AXE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.HOE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_HOE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_HOE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.PICKAXE,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_PICKAXE_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_PICKAXE_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.SHOVEL,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_SHOVEL_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_SHOVEL_ATTACK_DAMAGE::get,
                            null
                    ),
                    WoodenTieredItemType.SWORD,
                    new WoodenItemTier.TieredItemProperties(
                            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_SWORD_ATTACK_SPEED::get,
                            ILikeWoodConfig.SERVER_CONFIG.GOLDEN_SWORD_ATTACK_DAMAGE::get,
                            null
                    )
            )
    );
}
