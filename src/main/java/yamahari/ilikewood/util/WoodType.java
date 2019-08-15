package yamahari.ilikewood.util;

import net.minecraft.util.IStringSerializable;

import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class WoodType implements IStringSerializable {
    private final String name;
    private final String modId;
    private final Map<WoodenBlockType, WoodTypeProperties> woodTypeProperties;

    public WoodType(String name, String modId, Map<WoodenBlockType, WoodTypeProperties> woodTypeProperties) {
        this.name = name;
        this.modId = modId;
        this.woodTypeProperties = woodTypeProperties;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getModId() {
        return modId;
    }

    public WoodTypeProperties getWoodTypeProperties(WoodenBlockType woodenBlockType) {
        return this.woodTypeProperties.getOrDefault(woodenBlockType, new WoodTypeProperties(() -> -1));
    }

    public static class WoodTypeProperties {
        private final Supplier<Integer> burnTime;

        public WoodTypeProperties(Supplier<Integer> burnTime) {
            this.burnTime = burnTime;
        }

        public int getBurnTime() {
            return this.burnTime.get();
        }
    }
}
