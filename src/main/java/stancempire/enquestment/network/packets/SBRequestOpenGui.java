package stancempire.enquestment.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.neoforge.network.NetworkEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import stancempire.enquestment.network.NetworkManager;
import stancempire.enquestment.network.util.ModScreen;

public class SBRequestOpenGui
{

    private ModScreen screen;
    public SBRequestOpenGui(ModScreen pScreen)
    {

        this.screen = pScreen;

    }

    //Encode
    public void encode(FriendlyByteBuf buf)
    {

        buf.writeEnum(this.screen);

    }

    //Decode
    public SBRequestOpenGui(FriendlyByteBuf buf)
    {

        this.screen = buf.readEnum(ModScreen.class);

    }

    //Handle
    public void handle(NetworkEvent.Context ctx)
    {

        ctx.enqueueWork(() ->
        {

            if(this.screen != null)
            {

                NetworkManager.NETWORK_INSTANCE.send(PacketDistributor.PLAYER.with(ctx::getSender), new CBOpenGui(this.screen));

            }

        });

    }


}