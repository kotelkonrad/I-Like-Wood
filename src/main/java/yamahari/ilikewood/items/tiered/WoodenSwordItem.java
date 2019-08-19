package yamahari.ilikewood.items.tiered;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import yamahari.ilikewood.tier.WoodenItemTier;
import yamahari.ilikewood.tier.WoodenTieredItemType;
import yamahari.ilikewood.util.WoodType;

public class WoodenSwordItem extends WoodenTieredItem {
    public WoodenSwordItem(WoodType woodType, WoodenItemTier woodenItemTier) {
        super(woodType, woodenItemTier, WoodenTieredItemType.SWORD, (new Item.Properties()).group(ItemGroup.COMBAT));
    }

    @Override
    public boolean canPlayerBreakBlockWhileHolding(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity) {
        return !playerEntity.isCreative();
    }

    @Override
    public float getDestroySpeed(ItemStack itemStack, BlockState blockState) {
        Block block = blockState.getBlock();
        if (block == Blocks.COBWEB) {
            return 15.0F;
        } else {
            Material material = blockState.getMaterial();
            return material != Material.PLANTS && material != Material.TALL_PLANTS && material != Material.CORAL && !blockState.isIn(BlockTags.LEAVES) && material != Material.GOURD ? 1.0F : 1.5F;
        }
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        itemStack.damageItem(1, attacker, (livingEntity) -> {
            livingEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, BlockState blockState, BlockPos blockPos, LivingEntity entityLiving) {
        if (blockState.getBlockHardness(world, blockPos) != 0.0F) {
            itemStack.damageItem(2, entityLiving, (livingEntity) -> {
                livingEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
            });
        }
        return true;
    }

    @Override
    public boolean canHarvestBlock(BlockState blockState) {
        return blockState.getBlock() == Blocks.COBWEB;
    }
}
