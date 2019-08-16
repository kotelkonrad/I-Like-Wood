package yamahari.ilikewood.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;
import yamahari.ilikewood.util.WoodenObjectType;

public class WoodenWallBlock extends WallBlock implements IWooden {
    private final WoodType woodType;

    public WoodenWallBlock(WoodType woodType) {
        super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD));
        this.woodType = woodType;
        this.setRegistryName(this.getWoodType().getModId(), this.getWoodType().getName() + "_" + WoodenObjectType.WALL.getName());
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }
}
