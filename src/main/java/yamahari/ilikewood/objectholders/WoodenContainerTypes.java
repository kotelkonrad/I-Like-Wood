package yamahari.ilikewood.objectholders;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.registries.ObjectHolder;
import yamahari.ilikewood.container.WoodenLecternContainer;
import yamahari.ilikewood.container.WoodenWorkbenchContainer;
import yamahari.ilikewood.util.Constants;

@ObjectHolder(Constants.MOD_ID)
public class WoodenContainerTypes {
    @ObjectHolder("wooden_lectern")
    public static final ContainerType<WoodenLecternContainer> LECTERN = null;

    @ObjectHolder("wooden_workbench")
    public static final ContainerType<WoodenWorkbenchContainer> WORKBENCH = null;
}
