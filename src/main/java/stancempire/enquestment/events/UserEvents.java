package stancempire.enquestment.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.TickEvent;
import stancempire.enquestment.client.ClientSetup;
import stancempire.enquestment.network.NetworkManager;
import stancempire.enquestment.network.packets.SBRequestOpenGui;
import stancempire.enquestment.network.util.ModScreen;

/**
 * <p>CLIENT CODE</p>
 * Class for handling user input events
 */
public class UserEvents
{

    /**
     * Checks for custom keybinds
     */
    @SubscribeEvent
    public void onKeyPressed(TickEvent.ClientTickEvent event)
    {

        if(event.phase == TickEvent.Phase.END) //Prevent logic from being executed twice
        {

            while(ClientSetup.EMENU_KEY.get().consumeClick()) //EMENU key
            {

                NetworkManager.NETWORK_INSTANCE.sendToServer(new SBRequestOpenGui(ModScreen.TEST));

            }

        }

    }

}
