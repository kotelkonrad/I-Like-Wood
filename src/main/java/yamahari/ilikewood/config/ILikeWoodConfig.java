package yamahari.ilikewood.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ILikeWoodConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final CommonConfig COMMON_CONFIG;

    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final ClientConfig CLIENT_CONFIG;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> common =
                new ForgeConfigSpec.Builder().configure(CommonConfig::new);

        final Pair<ClientConfig, ForgeConfigSpec> client =
                new ForgeConfigSpec.Builder().configure(ClientConfig::new);

        COMMON_SPEC = common.getRight();
        COMMON_CONFIG = common.getLeft();

        CLIENT_SPEC = client.getRight();
        CLIENT_CONFIG = client.getLeft();
    }
}
