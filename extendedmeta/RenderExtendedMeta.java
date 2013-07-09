package extendedmeta;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderExtendedMeta implements ISimpleBlockRenderingHandler
{

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        // metadata is the itemstacks damage thus the extended metadata
        // put your item rendering code here
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        TileEntity tile = world.getBlockTileEntity(x, y, z);
        if (!(tile instanceof TileExtendedMeta)) {
            return false;
        }
        int metadata = ((TileExtendedMeta)tile).metaEx;
        int direction = ((TileExtendedMeta)tile).direction;
        // put your block rendering code here
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory()
    {
        return true;
    }

    @Override
    public int getRenderId()
    {
        return ExtendedMeta.renderId;
    }
}