package extendedmeta;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemExtendedMeta extends ItemBlock
{
    public ItemExtendedMeta(int id)
    {
        super(id);
        this.
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return getUnlocalizedName() + "." + itemStack.getItemDamage();
    }

    public boolean placeBlockAt(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
        if (world.setBlock(x, y, z, getBlockID(), 0, 3)) {
            if (world.getBlockId(x, y, z) == getBlockID()) {
                TileEntity tile = world.getBlockTileEntity(x, y, z);
                if (tile instanceof TileExtendedMeta) {
                    ((TileExtendedMeta)tile).metaEx = itemStack.getItemDamage();
                    ((TileExtendedMeta)tile).direction = MathHelper.floor_double(entityPlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
                    Block.blocksList[getBlockID()].onBlockPlacedBy(world, x, y, z, entityPlayer, itemStack);
                    Block.blocksList[getBlockID()].onPostBlockPlaced(world, x, y, z, metadata);
                    return true;
                }
            }
        }
        return false;
    }
}