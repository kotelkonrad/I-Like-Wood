package yamahari.ilikewood.util;

import com.google.common.collect.ImmutableMap;
import net.minecraft.util.ResourceLocation;

public class Constants {
    public static final String MOD_ID = "ilikewood";

    public static final ResourceLocation TEXTURE_CHEST_DEFAULT = new ResourceLocation("minecraft", "textures/entity/chest/normal.png");
    public static final ResourceLocation TEXTURE_CHEST_DOUBLE_DEFAULT = new ResourceLocation("minecraft", "textures/entity/chest/normal_double.png");

    public static final ImmutableMap<WoodType, ResourceLocation> TEXTURES_CHEST =
            (new ImmutableMap.Builder<WoodType, ResourceLocation>())
                    .put(WoodTypes.ACACIA, new ResourceLocation(MOD_ID, "textures/entity/chest/acacia.png"))
                    .put(WoodTypes.BIRCH, new ResourceLocation(MOD_ID, "textures/entity/chest/birch.png"))
                    .put(WoodTypes.DARK_OAK, new ResourceLocation(MOD_ID, "textures/entity/chest/dark_oak.png"))
                    .put(WoodTypes.JUNGLE, new ResourceLocation(MOD_ID, "textures/entity/chest/jungle.png"))
                    .put(WoodTypes.OAK, new ResourceLocation(MOD_ID, "textures/entity/chest/oak.png"))
                    .put(WoodTypes.SPRUCE, new ResourceLocation(MOD_ID, "textures/entity/chest/spruce.png"))
                    .build();

    public static final ImmutableMap<WoodType, ResourceLocation> TEXTURES_CHEST_DOUBLE =
            (new ImmutableMap.Builder<WoodType, ResourceLocation>())
                    .put(WoodTypes.ACACIA, new ResourceLocation(MOD_ID, "textures/entity/chest/double/acacia.png"))
                    .put(WoodTypes.BIRCH, new ResourceLocation(MOD_ID, "textures/entity/chest/double/birch.png"))
                    .put(WoodTypes.DARK_OAK, new ResourceLocation(MOD_ID, "textures/entity/chest/double/dark_oak.png"))
                    .put(WoodTypes.JUNGLE, new ResourceLocation(MOD_ID, "textures/entity/chest/double/jungle.png"))
                    .put(WoodTypes.OAK, new ResourceLocation(MOD_ID, "textures/entity/chest/double/oak.png"))
                    .put(WoodTypes.SPRUCE, new ResourceLocation(MOD_ID, "textures/entity/chest/double/spruce.png"))
                    .build();
}