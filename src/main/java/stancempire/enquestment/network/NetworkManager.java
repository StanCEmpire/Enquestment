package stancempire.enquestment.network;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.NetworkRegistry;
import net.neoforged.neoforge.network.simple.SimpleChannel;
import stancempire.enquestment.Enquestment;
import stancempire.enquestment.network.packets.CBOpenGui;
import stancempire.enquestment.network.packets.SBRequestOpenGui;

public class NetworkManager
{

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel NETWORK_INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Enquestment.MOD_ID, "network"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    public static void registerMessages()
    {

        int id = 0;

        NETWORK_INSTANCE.registerMessage(id++, CBOpenGui.class, CBOpenGui::encode, CBOpenGui::new, CBOpenGui::handle);
        NETWORK_INSTANCE.registerMessage(id++, SBRequestOpenGui.class, SBRequestOpenGui::encode, SBRequestOpenGui::new, SBRequestOpenGui::handle);

    }

}