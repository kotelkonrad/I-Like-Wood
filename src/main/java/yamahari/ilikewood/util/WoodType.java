package yamahari.ilikewood.util;

import net.minecraft.util.IStringSerializable;

import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class WoodType implements IStringSerializable {
    private final String name;
    private final String modId;
    private final Map<WoodenItemType, WoodTypeProperties> woodTypeProperties;

    public WoodType(String name, String modId, Map<WoodenItemType, WoodTypeProperties> woodTypeProperties) {
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

    public WoodTypeProperties getWoodTypeProperties(WoodenItemType woodenItemType) {
        return this.woodTypeProperties.getOrDefault(woodenItemType, new WoodTypeProperties(() -> -1));
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
