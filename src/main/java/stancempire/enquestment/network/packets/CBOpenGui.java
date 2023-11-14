package stancempire.enquestment.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.neoforge.network.NetworkEvent;
import stancempire.enquestment.network.util.ModScreen;

import java.util.function.Supplier;

public class CBOpenGui
{

    private ModScreen screen;
    //Constructor for sending messages
    public CBOpenGui(ModScreen pScreen)
    {

        this.screen = pScreen;

    }
    //Encode
    public void encode(FriendlyByteBuf buf)
    {

        buf.writeEnum(this.screen);

    }

    //Decode
    public CBOpenGui(FriendlyByteBuf buf)
    {

        this.screen = buf.readEnum(ModScreen.class);

    }

    //Handle
    public void handle(NetworkEvent.Context ctx)
    {

        

    }

}
