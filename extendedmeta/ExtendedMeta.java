package extendedmeta;

import java.io.File;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
        modid = "ExtendedMeta",
        name = "ExtendedMeta",
        version = "1.0" )

public class ExtendedMeta
{
    public static int renderId;
    public static Block blockExtendedMeta;

    @Instance("ExtendedMeta")
    public static ExtendedMeta INSTANCE;

    @SidedProxy(
        clientSide = "extendedmeta.ProxyClient",
        serverSide = "extendedmeta.ProxyCommon")
    public static ProxyCommon	proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Configuration forgeConfig = new Configuration(new File(event.getModConfigurationDirectory(), "ExtendedMeta.cfg"));
        forgeConfig.load();
        int idExtendedMetaBlock = forgeConfig.getBlock("idExtendedMetaBlock", 4000).getInt();
        forgeConfig.save();

        if (idExtendedMetaBlock > 0) {
            ExtendedMeta.blockExtendedMeta = new BlockExtendedMeta(idExtendedMetaBlock, Material.rock).setUnlocalizedName("extendedmeta");
            GameRegistry.registerBlock(ExtendedMeta.blockExtendedMeta, "ExtendedMeta.extendedmeta");
            GameRegistry.registerTileEntity(TileExtendedMeta.class, "ExtendedMeta.tileextendedmeta");
        }
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        if (ExtendedMeta.blockExtendedMeta != null) {
            // register recipies
        }
        proxy.registerRenderInformation();
    }
}