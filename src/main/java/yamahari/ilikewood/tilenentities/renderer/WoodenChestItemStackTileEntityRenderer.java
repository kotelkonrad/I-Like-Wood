package yamahari.ilikewood.tilenentities.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yamahari.ilikewood.blocks.WoodenChestBlock;

@OnlyIn(Dist.CLIENT)
public class WoodenChestItemStackTileEntityRenderer extends ItemStackTileEntityRenderer {
    @SuppressWarnings("ConstantConditions")
    @Override
    public void renderByItem(ItemStack itemStack) {
        Block block = Block.getBlockFromItem(itemStack.getItem());
        if (block instanceof WoodenChestBlock) {
            WoodenChestBlock woodenChestBlock = (WoodenChestBlock) block;
            TileEntity tileEntity = woodenChestBlock.getTileEntityType().create();
            TileEntityRenderer tileEntityRenderer = TileEntityRendererDispatcher.instance.getRenderer(tileEntity);
            if (tileEntityRenderer instanceof WoodenChestTileEntityRenderer) {
                WoodenChestTileEntityRenderer woodenChestTileEntityRenderer = (WoodenChestTileEntityRenderer) tileEntityRenderer;
                woodenChestTileEntityRenderer.renderImpl(tileEntity, 0.0D, 0.0D, 0.0D, 0.0F, -1, woodenChestBlock.getWoodType());
            }
        } else {
            super.renderByItem(itemStack);
        }
    }
}
