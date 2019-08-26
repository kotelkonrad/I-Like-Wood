package yamahari.ilikewood.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;

public class WoodenSlabBlock extends SlabBlock implements IWooden {
    private final WoodType woodType;

    public WoodenSlabBlock(WoodType woodType, Block.Properties properties) {
        super(properties);
        this.woodType = woodType;
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }
}
