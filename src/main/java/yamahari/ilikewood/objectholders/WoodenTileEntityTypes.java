package yamahari.ilikewood.objectholders;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import yamahari.ilikewood.tilenentities.WoodenBarrelTileEntity;
import yamahari.ilikewood.tilenentities.WoodenChestTileEntity;
import yamahari.ilikewood.tilenentities.WoodenLecternTileEntity;
import yamahari.ilikewood.util.Constants;

@ObjectHolder(Constants.MOD_ID)
public class WoodenTileEntityTypes {

    @ObjectHolder("wooden_barrel")
    public static final TileEntityType<WoodenBarrelTileEntity> BARREL = null;

    @ObjectHolder("wooden_chest")
    public static final TileEntityType<WoodenChestTileEntity> CHEST = null;

    @ObjectHolder("wooden_lectern")
    public static final TileEntityType<WoodenLecternTileEntity> LECTERN = null;
}
