package yamahari.ilikewood.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import yamahari.ilikewood.util.WoodType;
import yamahari.ilikewood.util.WoodenBlockType;

public class WoodenBookshelfBlock extends WoodenBlock {
    public WoodenBookshelfBlock(WoodType woodType) {
        super(woodType, Block.Properties.create(Material.WOOD).hardnessAndResistance(1.5f).sound(SoundType.WOOD));
        this.setRegistryName(this.getWoodType().getModId(), this.getWoodType().getName() + "_" + WoodenBlockType.BOOKSHELF.getName());
    }

    @Override
    public float getEnchantPowerBonus(BlockState blockState, IWorldReader worldReader, BlockPos blockPos) {
        return this.getWoodType().getEnchantingPowerBonus();
    }
}
