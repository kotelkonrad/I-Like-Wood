package yamahari.ilikewood.util;

import net.minecraft.util.IStringSerializable;

public enum WoodenItemType implements IStringSerializable {
    BARREL("barrel"),
    CHEST("chest"),
    LECTERN("lectern");

    private final String name;

    WoodenItemType(String name) {
        this.name = name;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String getName() {
        return this.name;
    }
}
