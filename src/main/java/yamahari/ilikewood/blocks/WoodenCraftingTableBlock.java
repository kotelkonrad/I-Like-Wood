package yamahari.ilikewood.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import yamahari.ilikewood.container.WoodenWorkbenchContainer;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;
import yamahari.ilikewood.util.WoodenObjectType;

public class WoodenCraftingTableBlock extends CraftingTableBlock implements IWooden {
    private final WoodType woodType;

    public WoodenCraftingTableBlock(WoodType woodType) {
        super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5f).sound(SoundType.WOOD));
        this.woodType = woodType;
        this.setRegistryName(this.getWoodType().getModId(), this.getWoodType().getName() + "_" + WoodenObjectType.CRAFTING_TABLE.getName());
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean onBlockActivated(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        playerEntity.openContainer(blockState.getContainer(world, blockPos));
        playerEntity.addStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
        return true;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public INamedContainerProvider getContainer(BlockState blockState, World world, BlockPos blockPos) {
        return new SimpleNamedContainerProvider(
                (id, playerInventory, playerEntity) -> new WoodenWorkbenchContainer(id, playerInventory, IWorldPosCallable.of(world, blockPos)),
                new TranslationTextComponent("container." + this.getWoodType().getModId() + "." + this.getWoodType().getName() + "_" + WoodenObjectType.CRAFTING_TABLE.getName()));
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }
}
