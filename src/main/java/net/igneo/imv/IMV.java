package net.igneo.imv;

import com.mojang.logging.LogUtils;
import net.igneo.imv.block.ModBlocks;
import net.igneo.imv.item.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IMV.MOD_ID)
public class IMV
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "igneosminingrevamp";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public IMV()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Common setup code
    }

    // Add blocks and items to the creative tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        // Code for adding items/blocks to creative tabs
    }

    // Called when the server starts
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Server starting logic
    }

    // Client-specific event handler
    @Mod.EventBusSubscriber(modid = IMV.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Set the render layer for MOSSY_SATURINIUM to cutout
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOSSY_SATURINIUM.get(), RenderType.cutout());
        }
    }
}
