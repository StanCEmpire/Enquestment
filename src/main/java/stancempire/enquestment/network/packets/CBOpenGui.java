package stancempire.enquestment.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.neoforge.network.NetworkEvent;
import stancempire.enquestment.client.ClientPacketHandler;
import stancempire.enquestment.network.util.ModScreen;

/**
 * Instructs the client to display a certain GUI
 */
public class CBOpenGui
{

    private ModScreen screen;
    /**
     * Constructor for initialising the packet on the server
     */
    public CBOpenGui(ModScreen pScreen)
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
     * Constructor for decoding data on the client
     */
    public CBOpenGui(FriendlyByteBuf buf)
    {

        this.screen = buf.readEnum(ModScreen.class);

    }

    /**
     * Handles packet once recieved by the client
     */
    public void handle(NetworkEvent.Context ctx)
    {

        ctx.enqueueWork(() ->
        {

            if(this.screen != null)
            {

                ClientPacketHandler.openGui(this.screen);

            }

        });

    }

}