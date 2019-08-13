package yamahari.ilikewood.blocks;

import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import yamahari.ilikewood.tilenentities.WoodenBarrelTileEntity;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.WoodType;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class WoodenBarrelBlock extends BarrelBlock implements IWooden {
    private final WoodType woodType;
    private final Supplier<TileEntityType<WoodenBarrelTileEntity>> tileEntityType;

    public WoodenBarrelBlock(WoodType woodType, Supplier<TileEntityType<WoodenBarrelTileEntity>> tileEntityType) {
        super(Block.Properties.from(Blocks.BARREL));
        this.woodType = woodType;
        this.tileEntityType = tileEntityType;
        this.setRegistryName(this.woodType.getModId(), this.woodType.getName() + "_barrel");
    }

    @Override
    public boolean onBlockActivated(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        if (world.isRemote) {
            return true;
        } else {
            TileEntity tileEntity = world.getTileEntity(blockPos);
            if (tileEntity instanceof WoodenBarrelTileEntity) {
                playerEntity.openContainer((WoodenBarrelTileEntity)tileEntity);
                playerEntity.addStat(Stats.OPEN_BARREL);
            }
            return true;
        }
    }

    public TileEntityType<WoodenBarrelTileEntity> getTileEntityType() {
        return this.tileEntityType.get();
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader blockReader) {
        return this.tileEntityType.get().create();
    }

    @Override
    public void tick(BlockState blockState, World world, BlockPos blockPos, Random random) {
        TileEntity tileEntity = world.getTileEntity(blockPos);
        if (tileEntity instanceof WoodenBarrelTileEntity) {
            ((WoodenBarrelTileEntity)tileEntity).tick();
        }

    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity livingEntity, ItemStack itemStack) {
        if (itemStack.hasDisplayName()) {
            TileEntity tileEntity = world.getTileEntity(blockPos);
            if (tileEntity instanceof WoodenBarrelTileEntity) {
                ((WoodenBarrelTileEntity)tileEntity).setCustomName(itemStack.getDisplayName());
            }
        }
    }

    @Override
    public WoodType getWoodType() {
        return this.woodType;
    }
}
