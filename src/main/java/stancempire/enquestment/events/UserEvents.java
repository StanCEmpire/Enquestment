package stancempire.enquestment.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.TickEvent;
import stancempire.enquestment.client.ClientSetup;
import stancempire.enquestment.network.NetworkManager;
import stancempire.enquestment.network.packets.SBRequestOpenGui;
import stancempire.enquestment.network.util.ModScreen;

public class UserEvents
{

    @SubscribeEvent
    public void onKeyPressed(TickEvent.ClientTickEvent event)
    {

        if(event.phase == TickEvent.Phase.END)
        {

            while(ClientSetup.EMENU_KEY.get().consumeClick())
            {

                NetworkManager.NETWORK_INSTANCE.sendToServer(new SBRequestOpenGui(ModScreen.TEST));

            }

        }

    }

}
