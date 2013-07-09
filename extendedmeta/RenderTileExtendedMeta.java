package extendedmeta;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderTileExtendedMeta extends TileEntitySpecialRenderer
{
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTick)
    {
        if (!(tileEntity instanceof TileExtendedMeta)) {
            return;
        }

        TileExtendedMeta blockTile = (TileExtendedMeta)tileEntity;
        int metadata = ((TileExtendedMeta)blockTile).metaEx;
        int direction = ((TileExtendedMeta)blockTile).direction;

        // put your model rendering code here
    }
}