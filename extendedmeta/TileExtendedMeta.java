package extendedmeta;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileExtendedMeta extends TileEntity
{
    public int metaEx = 0;
    public int direction = 0;

    @Override
    public void writeToNBT(NBTTagCompound nbtTag)
    {
        super.writeToNBT(nbtTag);
        nbtTag.setInteger("metaEx", this.metaEx);
        nbtTag.setInteger("direction", this.direction);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTag)
    {
        super.readFromNBT(nbtTag);
        this.metaEx = nbtTag.getInteger("metaEx");
        this.direction = nbtTag.getInteger("direction");
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbtTag = new NBTTagCompound();
        nbtTag.setInteger("metaEx", this.metaEx);
        nbtTag.setInteger("direction", this.direction);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
    }

    @Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
    {
        this.metaEx = pkt.customParam1.getInteger("metaEx");
        this.direction = pkt.customParam1.getInteger("direction");
        this.worldObj.markBlockForRenderUpdate(this.xCoord, this.yCoord, this.zCoord);
    }
}