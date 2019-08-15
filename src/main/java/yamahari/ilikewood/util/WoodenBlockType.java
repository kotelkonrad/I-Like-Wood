package yamahari.ilikewood.util;

import net.minecraft.util.IStringSerializable;

public enum WoodenBlockType implements IStringSerializable {
    BARREL("barrel"),
    CHEST("chest"),
    LECTERN("lectern"),
    PANELS("panels");

    private final String name;

    WoodenBlockType(String name) {
        this.name = name;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String getName() {
        return this.name;
    }
}
