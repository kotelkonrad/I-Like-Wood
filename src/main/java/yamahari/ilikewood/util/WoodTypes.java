package yamahari.ilikewood.util;

import com.google.common.collect.ImmutableMap;
import yamahari.ilikewood.config.ILikeWoodConfig;

public class WoodTypes {
    public static final WoodType ACACIA = new WoodType(
            "acacia",
            Constants.MOD_ID,
            ImmutableMap.of(
                    WoodenItemType.BARREL,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_BARREL_BURN_TIME::get
                    ),
                    WoodenItemType.CHEST,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_CHEST_BURN_TIME::get
                    ),
                    WoodenItemType.LECTERN,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.ACACIA_LECTERN_BURN_TIME::get
                    )
            )
    );

    public static final WoodType BIRCH = new WoodType(
            "birch",
            Constants.MOD_ID,
            ImmutableMap.of(
                    WoodenItemType.BARREL,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_BARREL_BURN_TIME::get
                    ),
                    WoodenItemType.CHEST,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_CHEST_BURN_TIME::get
                    ),
                    WoodenItemType.LECTERN,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.BIRCH_LECTERN_BURN_TIME::get
                    )
            )
    );

    public static final WoodType DARK_OAK = new WoodType(
            "dark_oak",
            Constants.MOD_ID,
            ImmutableMap.of(
                    WoodenItemType.BARREL,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_BARREL_BURN_TIME::get
                    ),
                    WoodenItemType.CHEST,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_CHEST_BURN_TIME::get
                    ),
                    WoodenItemType.LECTERN,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.DARK_OAK_LECTERN_BURN_TIME::get
                    )
            )
    );

    public static final WoodType JUNGLE = new WoodType(
            "jungle",
            Constants.MOD_ID,
            ImmutableMap.of(
                    WoodenItemType.BARREL,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_BARREL_BURN_TIME::get
                    ),
                    WoodenItemType.CHEST,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_CHEST_BURN_TIME::get
                    ),
                    WoodenItemType.LECTERN,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.JUNGLE_LECTERN_BURN_TIME::get
                    )
            )
    );

    public static final WoodType OAK = new WoodType(
            "oak",
            Constants.MOD_ID,
            ImmutableMap.of(
                    WoodenItemType.BARREL,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.OAK_BARREL_BURN_TIME::get
                    ),
                    WoodenItemType.CHEST,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.OAK_CHEST_BURN_TIME::get
                    ),
                    WoodenItemType.LECTERN,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.OAK_LECTERN_BURN_TIME::get
                    )
            )
    );

    public static final WoodType SPRUCE = new WoodType(
            "spruce",
            Constants.MOD_ID,
            ImmutableMap.of(
                    WoodenItemType.BARREL,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_BARREL_BURN_TIME::get
                    ),
                    WoodenItemType.CHEST,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_CHEST_BURN_TIME::get
                    ),
                    WoodenItemType.LECTERN,
                    new WoodType.WoodTypeProperties(
                            ILikeWoodConfig.COMMON_CONFIG.SPRUCE_LECTERN_BURN_TIME::get
                    )
            )
    );
}
