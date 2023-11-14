package stancempire.enquestment.client;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import stancempire.enquestment.Enquestment;

public class ClientSetup
{

    public static void onClientSetup(final FMLClientSetupEvent event)
    {

        event.enqueueWork(() ->
        {

            Enquestment.LOGGER.info("Client Setup");
            //CLIENT SETUPM

        });

    }

}
