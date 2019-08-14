package yamahari.ilikewood.tilenentities.renderer;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.entity.model.BookModel;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yamahari.ilikewood.blocks.WoodenLecternBlock;
import yamahari.ilikewood.tilenentities.WoodenLecternTileEntity;

@OnlyIn(Dist.CLIENT)
public class WoodenLecternTileEntityRenderer extends TileEntityRenderer<WoodenLecternTileEntity> {
    private static final ResourceLocation TEXTURE_ENCHANTING_TABLE_BOOK = new ResourceLocation("minecraft", "textures/entity/enchanting_table_book.png");
    private final BookModel bookModel = new BookModel();

    @Override
    public void render(WoodenLecternTileEntity woodenLecternTileEntity, double x, double y, double z, float partialTicks, int destroyStage) {
        BlockState blockState = woodenLecternTileEntity.getBlockState();
        if (blockState.get(WoodenLecternBlock.HAS_BOOK)) {
            GlStateManager.pushMatrix();
            GlStateManager.translatef((float) x + 0.5F, (float) y + 1.0F + 0.0625F, (float) z + 0.5F);
            float lvt_11_1_ = blockState.get(WoodenLecternBlock.FACING).rotateY().getHorizontalAngle();
            GlStateManager.rotatef(-lvt_11_1_, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotatef(67.5F, 0.0F, 0.0F, 1.0F);
            GlStateManager.translatef(0.0F, -0.125F, 0.0F);
            this.bindTexture(TEXTURE_ENCHANTING_TABLE_BOOK);
            GlStateManager.enableCull();
            this.bookModel.render(0.0F, 0.1F, 0.9F, 1.2F, 0.0F, 0.0625F);
            GlStateManager.popMatrix();
        }
    }
}
