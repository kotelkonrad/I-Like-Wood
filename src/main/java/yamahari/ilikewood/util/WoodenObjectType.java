package yamahari.ilikewood.util;

import net.minecraft.util.IStringSerializable;

public enum WoodenObjectType implements IStringSerializable {
    BARREL("barrel"),
    BOOKSHELF("bookshelf"),
    CHEST("chest"),
    COMPOSTER("composter"),
    LADDER("ladder"),
    LECTERN("lectern"),
    PANELS("panels"),
    SCAFFOLDING("scaffolding"),
    STICK("stick"),
    WALL("wall");

    private final String name;

    WoodenObjectType(String name) {
        this.name = name;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String getName() {
        return this.name;
    }
}
