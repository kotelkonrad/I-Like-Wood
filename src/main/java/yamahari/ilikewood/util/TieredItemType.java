package yamahari.ilikewood.util;

import net.minecraft.util.IStringSerializable;

public enum TieredItemType implements IStringSerializable {
    AXE("axe"),
    HOE("hoe"),
    PICKAXE("pickaxe"),
    SHOVEL("shovel"),
    SWORD("sword");

    private final String name;

    TieredItemType(String name) {
        this.name = name;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String getName() {
        return this.name;
    }
}
