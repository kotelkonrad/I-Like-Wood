package yamahari.ilikewood.objectholders.lectern;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.registries.ObjectHolder;
import yamahari.ilikewood.container.WoodenLecternContainer;
import yamahari.ilikewood.util.Constants;

@ObjectHolder(Constants.MOD_ID)
public class WoodenLecternContainers {

    @ObjectHolder("wooden_lectern_container")
    public static final ContainerType<WoodenLecternContainer> WOODEN = null;
}
