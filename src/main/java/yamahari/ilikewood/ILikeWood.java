package yamahari.ilikewood;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yamahari.ilikewood.blocks.*;
import yamahari.ilikewood.config.ILikeWoodConfig;
import yamahari.ilikewood.container.WoodenLecternContainer;
import yamahari.ilikewood.items.WoodenBlockItem;
import yamahari.ilikewood.objectholders.WoodenTileEntityTypes;
import yamahari.ilikewood.objectholders.barrel.WoodenBarrelBlocks;
import yamahari.ilikewood.objectholders.bookshelf.WoodenBookshelfBlocks;
import yamahari.ilikewood.objectholders.chest.WoodenChestBlocks;
import yamahari.ilikewood.objectholders.lectern.WoodenLecternBlocks;
import yamahari.ilikewood.objectholders.panels.WoodenPanelsBlocks;
import yamahari.ilikewood.proxy.ClientProxy;
import yamahari.ilikewood.proxy.CommonProxy;
import yamahari.ilikewood.proxy.IProxy;
import yamahari.ilikewood.tilenentities.WoodenBarrelTileEntity;
import yamahari.ilikewood.tilenentities.WoodenChestTileEntity;
import yamahari.ilikewood.tilenentities.WoodenLecternTileEntity;
import yamahari.ilikewood.tilenentities.renderer.WoodenChestItemStackTileEntityRenderer;
import yamahari.ilikewood.util.Constants;
import yamahari.ilikewood.util.WoodTypes;
import yamahari.ilikewood.util.WoodenBlockType;

import java.util.stream.Stream;

@Mod(Constants.MOD_ID)
public class ILikeWood {
    @SuppressWarnings("unused")
    public static final Logger logger = LogManager.getLogger(Constants.MOD_ID);

    private static final IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

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
            Stream.of(WoodTypes.ACACIA, WoodTypes.BIRCH, WoodTypes.DARK_OAK, WoodTypes.JUNGLE, WoodTypes.OAK, WoodTypes.SPRUCE)
                    .forEach(
                            woodType -> event.getRegistry().registerAll(
                                    new WoodenBarrelBlock(woodType, () -> WoodenTileEntityTypes.BARREL),
                                    new WoodenChestBlock(woodType, () -> WoodenTileEntityTypes.CHEST),
                                    new WoodenLecternBlock(woodType, () -> WoodenTileEntityTypes.LECTERN),
                                    new WoodenBlock(woodType, Block.Properties.create(Material.WOOD).hardnessAndResistance(2.f).sound(SoundType.WOOD)).setRegistryName(woodType.getName() + "_" + WoodenBlockType.PANELS.getName()),
                                    new WoodenBookshelfBlock(woodType)
                            )
                    );
        }

        @SuppressWarnings("ConstantConditions")
        @SubscribeEvent
        public static void onRegisterItem(final RegistryEvent.Register<Item> event) {
            IForgeRegistry<Item> itemRegistry = event.getRegistry();

            Stream.of(WoodenBarrelBlocks.ACACIA, WoodenBarrelBlocks.BIRCH, WoodenBarrelBlocks.DARK_OAK, WoodenBarrelBlocks.JUNGLE, WoodenBarrelBlocks.OAK, WoodenBarrelBlocks.SPRUCE)
                    .forEach(block -> itemRegistry.register(new WoodenBlockItem(block, WoodenBlockType.BARREL, (new Item.Properties()).group(ItemGroup.DECORATIONS))));

            Stream.of(WoodenChestBlocks.ACACIA, WoodenChestBlocks.BIRCH, WoodenChestBlocks.DARK_OAK, WoodenChestBlocks.JUNGLE, WoodenChestBlocks.OAK, WoodenChestBlocks.SPRUCE)
                    .forEach(block -> itemRegistry.register(new WoodenBlockItem(block, WoodenBlockType.CHEST, (new Item.Properties()).group(ItemGroup.DECORATIONS).setTEISR(() -> WoodenChestItemStackTileEntityRenderer::new))));

            Stream.of(WoodenLecternBlocks.ACACIA, WoodenLecternBlocks.BIRCH, WoodenLecternBlocks.DARK_OAK, WoodenLecternBlocks.JUNGLE, WoodenLecternBlocks.OAK, WoodenLecternBlocks.SPRUCE)
                    .forEach(block -> itemRegistry.register(new WoodenBlockItem(block, WoodenBlockType.LECTERN, (new Item.Properties()).group(ItemGroup.REDSTONE))));

            Stream.of(WoodenPanelsBlocks.ACACIA, WoodenPanelsBlocks.BIRCH, WoodenPanelsBlocks.DARK_OAK, WoodenPanelsBlocks.JUNGLE, WoodenPanelsBlocks.OAK, WoodenPanelsBlocks.SPRUCE)
                    .forEach(block -> itemRegistry.register(new WoodenBlockItem(block, WoodenBlockType.PANELS, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS))));

            Stream.of(WoodenBookshelfBlocks.ACACIA, WoodenBookshelfBlocks.BIRCH, WoodenBookshelfBlocks.DARK_OAK, WoodenBookshelfBlocks.JUNGLE, WoodenBookshelfBlocks.OAK, WoodenBookshelfBlocks.SPRUCE)
                    .forEach(block -> itemRegistry.register(new WoodenBlockItem(block, WoodenBlockType.BOOKSHELF, (new Item.Properties()).group(ItemGroup.DECORATIONS))));
        }

        @SuppressWarnings("ConstantConditions")
        @SubscribeEvent
        public static void onRegisterTileEntityType(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().registerAll(
                    TileEntityType.Builder.create(
                            () -> new WoodenBarrelTileEntity(WoodenTileEntityTypes.BARREL),
                            WoodenBarrelBlocks.ACACIA, WoodenBarrelBlocks.BIRCH, WoodenBarrelBlocks.DARK_OAK, WoodenBarrelBlocks.JUNGLE, WoodenBarrelBlocks.OAK, WoodenBarrelBlocks.SPRUCE
                    ).build(null).setRegistryName("wooden_barrel"),
                    TileEntityType.Builder.create(
                            () -> new WoodenChestTileEntity(WoodenTileEntityTypes.CHEST, Constants.TEXTURES_CHEST, Constants.TEXTURES_CHEST_DOUBLE),
                            WoodenChestBlocks.ACACIA, WoodenChestBlocks.BIRCH, WoodenChestBlocks.DARK_OAK, WoodenChestBlocks.JUNGLE, WoodenChestBlocks.OAK, WoodenChestBlocks.SPRUCE
                    ).build(null).setRegistryName("wooden_chest"),
                    TileEntityType.Builder.create(
                            () -> new WoodenLecternTileEntity(WoodenTileEntityTypes.LECTERN),
                            WoodenLecternBlocks.ACACIA, WoodenLecternBlocks.BIRCH, WoodenLecternBlocks.DARK_OAK, WoodenLecternBlocks.JUNGLE, WoodenLecternBlocks.OAK, WoodenLecternBlocks.SPRUCE
                    ).build(null).setRegistryName("wooden_lectern")
            );
        }

        @SubscribeEvent
        public static void onRegisterContainerType(final RegistryEvent.Register<ContainerType<?>> event) {
            event.getRegistry().registerAll(
                    new ContainerType<>((IContainerFactory<WoodenLecternContainer>) (windowId, inv, data) -> new WoodenLecternContainer(windowId)).setRegistryName("wooden_lectern")
            );
        }
    }
}