package stancempire.enquestment.network;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.NetworkRegistry;
import net.neoforged.neoforge.network.simple.SimpleChannel;
import stancempire.enquestment.Enquestment;
import stancempire.enquestment.network.packets.CBOpenGui;

public class NetworkManager
{

    private static final String PROTOCOL_VERSION = "1";
    private int id = 0;
    public static final SimpleChannel NETWORK_INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Enquestment.MOD_ID, "network"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    public void registerMessages()
    {

        NETWORK_INSTANCE.registerMessage(id++, CBOpenGui.class, CBOpenGui::encode, CBOpenGui::new, CBOpenGui::handle);

    }

}