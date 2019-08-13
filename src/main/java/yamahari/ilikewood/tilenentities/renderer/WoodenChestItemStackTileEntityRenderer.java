package yamahari.ilikewood.tilenentities.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import yamahari.ilikewood.blocks.WoodenChestBlock;

public class WoodenChestItemStackTileEntityRenderer extends ItemStackTileEntityRenderer {
    @SuppressWarnings("ConstantConditions")
    @Override
    public void renderByItem(ItemStack itemStack) {
        Block block = Block.getBlockFromItem(itemStack.getItem());
        if (block instanceof WoodenChestBlock) {
            TileEntityRendererDispatcher.instance.renderAsItem(((WoodenChestBlock) block).getTileEntityType().create());
        } else {
            super.renderByItem(itemStack);
        }
    }
}
