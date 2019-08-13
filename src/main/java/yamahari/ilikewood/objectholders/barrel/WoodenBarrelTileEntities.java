package yamahari.ilikewood.objectholders.barrel;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import yamahari.ilikewood.tilenentities.WoodenBarrelTileEntity;
import yamahari.ilikewood.util.Constants;

@ObjectHolder(Constants.MOD_ID)
public class WoodenBarrelTileEntities {

    @ObjectHolder("acacia_barrel")
    public static final TileEntityType<WoodenBarrelTileEntity> ACACIA_BARREL = null;

    @ObjectHolder("birch_barrel")
    public static final TileEntityType<WoodenBarrelTileEntity> BIRCH_BARREL = null;

    @ObjectHolder("dark_oak_barrel")
    public static final TileEntityType<WoodenBarrelTileEntity> DARK_OAK_BARREL = null;

    @ObjectHolder("jungle_barrel")
    public static final TileEntityType<WoodenBarrelTileEntity> JUNGLE_BARREL = null;

    @ObjectHolder("oak_barrel")
    public static final TileEntityType<WoodenBarrelTileEntity> OAK_BARREL = null;

    @ObjectHolder("spruce_barrel")
    public static final TileEntityType<WoodenBarrelTileEntity> SPRUCE_BARREL = null;
}
