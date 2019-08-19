package yamahari.ilikewood.tier;

import net.minecraft.util.IStringSerializable;

public enum WoodenTieredItemType implements IStringSerializable {
    AXE("axe"),
    HOE("hoe"),
    PICKAXE("pickaxe"),
    SHOVEL("shovel"),
    SWORD("sword");

    private final String name;

    WoodenTieredItemType(String name) {
        this.name = name;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String getName() {
        return this.name;
    }
}
