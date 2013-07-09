package extendedmeta;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ProxyClient extends ProxyCommon
{
    @Override
    public void registerRenderInformation()
    {
        ExtendedMeta.renderId = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderExtendedMeta());
        ClientRegistry.bindTileEntitySpecialRenderer(TileExtendedMeta.class, new RenderTileExtendedMeta()); // if you have models you need this
    }
}