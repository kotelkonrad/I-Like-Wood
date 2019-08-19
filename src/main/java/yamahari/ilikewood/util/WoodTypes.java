package yamahari.ilikewood.util;

import com.google.common.collect.ImmutableMap;
import yamahari.ilikewood.config.ILikeWoodConfig;

public class WoodTypes {
    public static final WoodType ACACIA = new WoodType(
            "acacia",
            Constants.MOD_ID,
            new ImmutableMap.Builder<WoodenObjectType, WoodType.WoodTypeProperties>()
                    .put(WoodenObjectType.BARREL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.ACACIA_BARREL_BURN_TIME::get))
                    .put(WoodenObjectType.CHEST, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.ACACIA_CHEST_BURN_TIME::get))
                    .put(WoodenObjectType.LECTERN, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.ACACIA_LECTERN_BURN_TIME::get))
                    .put(WoodenObjectType.PANELS, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.ACACIA_PANELS_BURN_TIME::get))
                    .put(WoodenObjectType.BOOKSHELF, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.ACACIA_BOOKSHELF_BURN_TIME::get))
                    .put(WoodenObjectType.COMPOSTER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.ACACIA_COMPOSTER_BURN_TIME::get))
                    .put(WoodenObjectType.WALL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.ACACIA_WALL_BURN_TIME::get))
                    .put(WoodenObjectType.LADDER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.ACACIA_LADDER_BURN_TIME::get))
                    .put(WoodenObjectType.STICK, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.ACACIA_STICK_BURN_TIME::get))
                    .build(),
            ILikeWoodConfig.SERVER_CONFIG.ACACIA_ENCHANTING_POWER_BONUS::get
    );

    public static final WoodType BIRCH = new WoodType(
            "birch",
            Constants.MOD_ID,
            new ImmutableMap.Builder<WoodenObjectType, WoodType.WoodTypeProperties>()
                    .put(WoodenObjectType.BARREL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.BIRCH_BARREL_BURN_TIME::get))
                    .put(WoodenObjectType.CHEST, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.BIRCH_CHEST_BURN_TIME::get))
                    .put(WoodenObjectType.LECTERN, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.BIRCH_LECTERN_BURN_TIME::get))
                    .put(WoodenObjectType.PANELS, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.BIRCH_PANELS_BURN_TIME::get))
                    .put(WoodenObjectType.BOOKSHELF, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.BIRCH_BOOKSHELF_BURN_TIME::get))
                    .put(WoodenObjectType.COMPOSTER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.BIRCH_COMPOSTER_BURN_TIME::get))
                    .put(WoodenObjectType.WALL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.BIRCH_WALL_BURN_TIME::get))
                    .put(WoodenObjectType.LADDER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.BIRCH_LADDER_BURN_TIME::get))
                    .put(WoodenObjectType.STICK, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.BIRCH_STICK_BURN_TIME::get))
                    .build(),
            ILikeWoodConfig.SERVER_CONFIG.BIRCH_ENCHANTING_POWER_BONUS::get
    );

    public static final WoodType DARK_OAK = new WoodType(
            "dark_oak",
            Constants.MOD_ID,
            new ImmutableMap.Builder<WoodenObjectType, WoodType.WoodTypeProperties>()
                    .put(WoodenObjectType.BARREL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_BARREL_BURN_TIME::get))
                    .put(WoodenObjectType.CHEST, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_CHEST_BURN_TIME::get))
                    .put(WoodenObjectType.LECTERN, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_LECTERN_BURN_TIME::get))
                    .put(WoodenObjectType.PANELS, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_PANELS_BURN_TIME::get))
                    .put(WoodenObjectType.BOOKSHELF, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_BOOKSHELF_BURN_TIME::get))
                    .put(WoodenObjectType.COMPOSTER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_COMPOSTER_BURN_TIME::get))
                    .put(WoodenObjectType.WALL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_WALL_BURN_TIME::get))
                    .put(WoodenObjectType.LADDER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_LADDER_BURN_TIME::get))
                    .put(WoodenObjectType.STICK, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_STICK_BURN_TIME::get))
                    .build(),
            ILikeWoodConfig.SERVER_CONFIG.DARK_OAK_ENCHANTING_POWER_BONUS::get
    );

    public static final WoodType JUNGLE = new WoodType(
            "jungle",
            Constants.MOD_ID,
            new ImmutableMap.Builder<WoodenObjectType, WoodType.WoodTypeProperties>()
                    .put(WoodenObjectType.BARREL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.JUNGLE_BARREL_BURN_TIME::get))
                    .put(WoodenObjectType.CHEST, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.JUNGLE_CHEST_BURN_TIME::get))
                    .put(WoodenObjectType.LECTERN, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.JUNGLE_LECTERN_BURN_TIME::get))
                    .put(WoodenObjectType.PANELS, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.JUNGLE_PANELS_BURN_TIME::get))
                    .put(WoodenObjectType.BOOKSHELF, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.JUNGLE_BOOKSHELF_BURN_TIME::get))
                    .put(WoodenObjectType.COMPOSTER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.JUNGLE_COMPOSTER_BURN_TIME::get))
                    .put(WoodenObjectType.WALL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.JUNGLE_WALL_BURN_TIME::get))
                    .put(WoodenObjectType.LADDER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.JUNGLE_LADDER_BURN_TIME::get))
                    .put(WoodenObjectType.STICK, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.JUNGLE_STICK_BURN_TIME::get))
                    .build(),
            ILikeWoodConfig.SERVER_CONFIG.JUNGLE_ENCHANTING_POWER_BONUS::get
    );

    public static final WoodType OAK = new WoodType(
            "oak",
            Constants.MOD_ID,
            new ImmutableMap.Builder<WoodenObjectType, WoodType.WoodTypeProperties>()
                    .put(WoodenObjectType.BARREL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.OAK_BARREL_BURN_TIME::get))
                    .put(WoodenObjectType.CHEST, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.OAK_CHEST_BURN_TIME::get))
                    .put(WoodenObjectType.LECTERN, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.OAK_LECTERN_BURN_TIME::get))
                    .put(WoodenObjectType.PANELS, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.OAK_PANELS_BURN_TIME::get))
                    .put(WoodenObjectType.BOOKSHELF, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.OAK_BOOKSHELF_BURN_TIME::get))
                    .put(WoodenObjectType.COMPOSTER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.OAK_COMPOSTER_BURN_TIME::get))
                    .put(WoodenObjectType.WALL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.OAK_WALL_BURN_TIME::get))
                    .put(WoodenObjectType.LADDER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.OAK_LADDER_BURN_TIME::get))
                    .put(WoodenObjectType.STICK, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.OAK_STICK_BURN_TIME::get))
                    .build(),
            ILikeWoodConfig.SERVER_CONFIG.OAK_ENCHANTING_POWER_BONUS::get
    );

    public static final WoodType SPRUCE = new WoodType(
            "spruce",
            Constants.MOD_ID,
            new ImmutableMap.Builder<WoodenObjectType, WoodType.WoodTypeProperties>()
                    .put(WoodenObjectType.BARREL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.SPRUCE_BARREL_BURN_TIME::get))
                    .put(WoodenObjectType.CHEST, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.SPRUCE_CHEST_BURN_TIME::get))
                    .put(WoodenObjectType.LECTERN, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.SPRUCE_LECTERN_BURN_TIME::get))
                    .put(WoodenObjectType.PANELS, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.SPRUCE_PANELS_BURN_TIME::get))
                    .put(WoodenObjectType.BOOKSHELF, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.SPRUCE_BOOKSHELF_BURN_TIME::get))
                    .put(WoodenObjectType.COMPOSTER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.SPRUCE_COMPOSTER_BURN_TIME::get))
                    .put(WoodenObjectType.WALL, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.SPRUCE_WALL_BURN_TIME::get))
                    .put(WoodenObjectType.LADDER, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.SPRUCE_LADDER_BURN_TIME::get))
                    .put(WoodenObjectType.STICK, new WoodType.WoodTypeProperties(ILikeWoodConfig.SERVER_CONFIG.SPRUCE_STICK_BURN_TIME::get))
                    .build(),
            ILikeWoodConfig.SERVER_CONFIG.SPRUCE_ENCHANTING_POWER_BONUS::get
    );
}
