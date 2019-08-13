package yamahari.ilikewood.tilenentities.renderer;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.model.ChestModel;
import net.minecraft.client.renderer.tileentity.model.LargeChestModel;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import yamahari.ilikewood.blocks.WoodenChestBlock;
import yamahari.ilikewood.objectholders.chest.WoodenChestBlocks;
import yamahari.ilikewood.tilenentities.WoodenChestTileEntity;

public class WoodenChestTileEntityRenderer<T extends TileEntity & IChestLid> extends TileEntityRenderer<T> {
    private final ChestModel simpleChest = new ChestModel();
    private final ChestModel largeChest = new LargeChestModel();

    @Override
    public void render(T tileEntity, double x, double y, double z, float partialTicks, int destroyStage) {
        GlStateManager.enableDepthTest();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
        BlockState blockState = tileEntity.hasWorld() ? tileEntity.getBlockState() : WoodenChestBlocks.OAK_CHEST.getDefaultState().with(ChestBlock.FACING, Direction.SOUTH);

        ChestType chestType = blockState.has(WoodenChestBlock.TYPE) ? blockState.get(WoodenChestBlock.TYPE) : ChestType.SINGLE;
        if (chestType != ChestType.LEFT) {
            boolean notSingle = chestType != ChestType.SINGLE;
            ChestModel chestModel = this.getChestModel(tileEntity, destroyStage, notSingle);
            if (destroyStage >= 0) {
                GlStateManager.matrixMode(5890);
                GlStateManager.pushMatrix();
                GlStateManager.scalef(notSingle ? 8.0F : 4.0F, 4.0F, 1.0F);
                GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
                GlStateManager.matrixMode(5888);
            } else {
                GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            GlStateManager.pushMatrix();
            GlStateManager.enableRescaleNormal();
            GlStateManager.translatef((float)x, (float)y + 1.0F, (float)z + 1.0F);
            GlStateManager.scalef(1.0F, -1.0F, -1.0F);
            float horizontalAngle = blockState.get(WoodenChestBlock.FACING).getHorizontalAngle();
            if ((double)Math.abs(horizontalAngle) > 1.0E-5D) {
                GlStateManager.translatef(0.5F, 0.5F, 0.5F);
                GlStateManager.rotatef(horizontalAngle, 0.0F, 1.0F, 0.0F);
                GlStateManager.translatef(-0.5F, -0.5F, -0.5F);
            }

            float lidAngle = tileEntity.getLidAngle(partialTicks);
            lidAngle = 1.0F - lidAngle;
            lidAngle = 1.0F - lidAngle * lidAngle * lidAngle;
            chestModel.getLid().rotateAngleX = -(lidAngle * 1.5707964F);

            chestModel.renderAll();
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            if (destroyStage >= 0) {
                GlStateManager.matrixMode(5890);
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5888);
            }

        }
    }

    private ChestModel getChestModel(T tileEntity, int destroyStage, boolean notSingle) {
        ResourceLocation resourceLocation;
        if (destroyStage >= 0) {
            resourceLocation = DESTROY_STAGES[destroyStage];
        }
        else if(tileEntity instanceof WoodenChestTileEntity) {
            resourceLocation = ((WoodenChestTileEntity)tileEntity).getChestResourceLocation(notSingle);
        }
        else {
            resourceLocation = notSingle ?
                    new ResourceLocation("minecraft", "textures/entity/chest/normal_double.png") :
                    new ResourceLocation("minecraft", "textures/entity/chest/normal.png");
        }
        this.bindTexture(resourceLocation);
        return notSingle ? this.largeChest : this.simpleChest;
    }
}
