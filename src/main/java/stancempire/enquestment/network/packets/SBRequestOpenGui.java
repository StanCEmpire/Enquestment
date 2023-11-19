package stancempire.enquestment.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.neoforge.network.NetworkEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import stancempire.enquestment.network.NetworkManager;
import stancempire.enquestment.network.util.ModScreen;

/**
 * Sends a request to the server to return a CBOpenGui packet
 */
public class SBRequestOpenGui
{

    private ModScreen screen;
    /**
     * Constructor for initialising the packet on the client
     */
    public SBRequestOpenGui(ModScreen pScreen)
    {

        this.screen = pScreen;

    }

    /**
     * Encodes data to the packet
     */
    public void encode(FriendlyByteBuf buf)
    {

        buf.writeEnum(this.screen);

    }

    /**
     * Constructor for decoding data on the server
     */
    public SBRequestOpenGui(FriendlyByteBuf buf)
    {

        this.screen = buf.readEnum(ModScreen.class);

    }

    /**
     * Handles packet once recieved by the server
     */
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