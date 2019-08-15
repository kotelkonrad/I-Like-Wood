package yamahari.ilikewood.blocks;

import net.minecraft.block.Block;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;

public class WoodenBlock extends Block implements IWooden {
    private final WoodType woodType;

    public WoodenBlock(WoodType woodType, Block.Properties properties) {
        super(properties);
        this.woodType = woodType;
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }
}
