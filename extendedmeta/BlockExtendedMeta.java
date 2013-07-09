package extendedmeta;

import java.util.ArrayList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockExtendedMeta extends BlockContainer
{
    protected BlockExtendedMeta(int id, Material material)
    {
        super(id, material);
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return new TileExtendedMeta();
    }

    @Override
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int meta, int fortune)
    {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        TileEntity tile = world.getBlockTileEntity(x, y, z);

        if (world.isRemote || !(tile instanceof TileExtendedMeta)) {
            return arrayList;
        }

        arrayList.add(new ItemStack(this, 1, ((TileExtendedMeta)tile).metaEx));
        return arrayList;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderType()
    {
        return ExtendedMeta.renderId;
    }
}