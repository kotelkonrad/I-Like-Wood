package yamahari.ilikewood;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yamahari.ilikewood.blocks.WoodenBarrelBlock;
import yamahari.ilikewood.blocks.WoodenChestBlock;
import yamahari.ilikewood.config.ILikeWoodConfig;
import yamahari.ilikewood.items.WoodenBarrelItem;
import yamahari.ilikewood.items.WoodenChestItem;
import yamahari.ilikewood.objectholders.barrel.WoodenBarrelBlocks;
import yamahari.ilikewood.objectholders.barrel.WoodenBarrelTileEntities;
import yamahari.ilikewood.objectholders.chest.WoodenChestBlocks;
import yamahari.ilikewood.objectholders.chest.WoodenChestTileEntities;
import yamahari.ilikewood.proxy.ClientProxy;
import yamahari.ilikewood.proxy.CommonProxy;
import yamahari.ilikewood.proxy.IProxy;
import yamahari.ilikewood.tilenentities.WoodenBarrelTileEntity;
import yamahari.ilikewood.tilenentities.WoodenChestTileEntity;
import yamahari.ilikewood.util.Constants;
import yamahari.ilikewood.util.WoodTypes;

import java.util.stream.Stream;

@Mod(Constants.MOD_ID)
public class ILikeWood {
    @SuppressWarnings("unused")
    public static final Logger logger = LogManager.getLogger(Constants.MOD_ID);

    private static final IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new CommonProxy());

    public ILikeWood() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ILikeWoodConfig.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ILikeWoodConfig.CLIENT_SPEC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(proxy::onFMLClientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(proxy::onFMLCommonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventHandler {
        @SubscribeEvent
        public static void onRegisterBlock(final RegistryEvent.Register<Block> event) {
            IForgeRegistry<Block> blockRegistry = event.getRegistry();

            blockRegistry.registerAll(
                    new WoodenBarrelBlock(WoodTypes.ACACIA, () -> WoodenBarrelTileEntities.ACACIA_BARREL),
                    new WoodenBarrelBlock(WoodTypes.BIRCH, () -> WoodenBarrelTileEntities.BIRCH_BARREL),
                    new WoodenBarrelBlock(WoodTypes.DARK_OAK, () -> WoodenBarrelTileEntities.DARK_OAK_BARREL),
                    new WoodenBarrelBlock(WoodTypes.JUNGLE, () -> WoodenBarrelTileEntities.JUNGLE_BARREL),
                    new WoodenBarrelBlock(WoodTypes.OAK, () -> WoodenBarrelTileEntities.OAK_BARREL),
                    new WoodenBarrelBlock(WoodTypes.SPRUCE, () -> WoodenBarrelTileEntities.SPRUCE_BARREL),
                    new WoodenChestBlock(WoodTypes.ACACIA, () -> WoodenChestTileEntities.ACACIA_CHEST),
                    new WoodenChestBlock(WoodTypes.BIRCH, () -> WoodenChestTileEntities.BIRCH_CHEST),
                    new WoodenChestBlock(WoodTypes.DARK_OAK, () -> WoodenChestTileEntities.DARK_OAK_CHEST),
                    new WoodenChestBlock(WoodTypes.JUNGLE, () -> WoodenChestTileEntities.JUNGLE_CHEST),
                    new WoodenChestBlock(WoodTypes.OAK, () -> WoodenChestTileEntities.OAK_CHEST),
                    new WoodenChestBlock(WoodTypes.SPRUCE, () -> WoodenChestTileEntities.SPRUCE_CHEST)
            );
        }

        @SuppressWarnings("ConstantConditions")
        @SubscribeEvent
        public static void onRegisterItem(final RegistryEvent.Register<Item> event) {
            IForgeRegistry<Item> itemRegistry = event.getRegistry();

            Stream.of(WoodenBarrelBlocks.ACACIA_BARREL, WoodenBarrelBlocks.BIRCH_BARREL, WoodenBarrelBlocks.DARK_OAK_BARREL, WoodenBarrelBlocks.JUNGLE_BARREL, WoodenBarrelBlocks.OAK_BARREL, WoodenBarrelBlocks.SPRUCE_BARREL)
                    .forEach(block -> itemRegistry.register(new WoodenBarrelItem(block)));

            Stream.of(WoodenChestBlocks.ACACIA_CHEST, WoodenChestBlocks.BIRCH_CHEST, WoodenChestBlocks.DARK_OAK_CHEST, WoodenChestBlocks.JUNGLE_CHEST, WoodenChestBlocks.OAK_CHEST, WoodenChestBlocks.SPRUCE_CHEST)
                    .forEach(block -> itemRegistry.register(new WoodenChestItem(block)));
        }

        @SuppressWarnings("ConstantConditions")
        @SubscribeEvent
        public static void onRegisterTileEntityType(final RegistryEvent.Register<TileEntityType<?>> event) {
            IForgeRegistry<TileEntityType<?>> tileEntityTypeRegistry = event.getRegistry();

            Stream.of(WoodenBarrelBlocks.ACACIA_BARREL, WoodenBarrelBlocks.BIRCH_BARREL, WoodenBarrelBlocks.DARK_OAK_BARREL, WoodenBarrelBlocks.JUNGLE_BARREL, WoodenBarrelBlocks.OAK_BARREL, WoodenBarrelBlocks.SPRUCE_BARREL)
                    .forEach(block -> tileEntityTypeRegistry.register(
                            TileEntityType.Builder.create(
                                    () -> new WoodenBarrelTileEntity(
                                            block.getTileEntityType(),
                                            block.getWoodType()
                                    ),
                                    block
                            ).build(null).setRegistryName(block.getRegistryName())
                    ));

            Stream.of(WoodenChestBlocks.ACACIA_CHEST, WoodenChestBlocks.BIRCH_CHEST, WoodenChestBlocks.DARK_OAK_CHEST, WoodenChestBlocks.JUNGLE_CHEST, WoodenChestBlocks.OAK_CHEST, WoodenChestBlocks.SPRUCE_CHEST)
                    .forEach(block -> tileEntityTypeRegistry.register(
                            TileEntityType.Builder.create(
                                    () -> new WoodenChestTileEntity(
                                            block.getTileEntityType(),
                                            block.getWoodType(),
                                            Constants.TEXTURE_CHEST.get(block.getWoodType()),
                                            Constants.TEXTURE_CHEST_DOUBLE.get(block.getWoodType())
                                    ),
                                    block
                            ).build(null).setRegistryName(block.getRegistryName())
                    ));
        }
    }
}