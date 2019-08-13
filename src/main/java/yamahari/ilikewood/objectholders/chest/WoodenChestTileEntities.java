package yamahari.ilikewood.objectholders.chest;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import yamahari.ilikewood.tilenentities.WoodenChestTileEntity;
import yamahari.ilikewood.util.Constants;

@ObjectHolder(Constants.MOD_ID)
public class WoodenChestTileEntities {

    @ObjectHolder("acacia_chest")
    public static final TileEntityType<WoodenChestTileEntity> ACACIA_CHEST = null;

    @ObjectHolder("birch_chest")
    public static final TileEntityType<WoodenChestTileEntity> BIRCH_CHEST = null;

    @ObjectHolder("dark_oak_chest")
    public static final TileEntityType<WoodenChestTileEntity> DARK_OAK_CHEST = null;

    @ObjectHolder("jungle_chest")
    public static final TileEntityType<WoodenChestTileEntity> JUNGLE_CHEST = null;

    @ObjectHolder("oak_chest")
    public static final TileEntityType<WoodenChestTileEntity> OAK_CHEST = null;

    @ObjectHolder("spruce_chest")
    public static final TileEntityType<WoodenChestTileEntity> SPRUCE_CHEST = null;
}
