package yamahari.ilikewood.util;

import net.minecraft.util.IStringSerializable;

public enum WoodenBlockType implements IStringSerializable {
    BARREL("barrel"),
    BOOKSHELF("bookshelf"),
    CHEST("chest"),
    COMPOSTER("composter"),
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
