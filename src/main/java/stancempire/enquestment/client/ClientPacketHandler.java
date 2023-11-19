package stancempire.enquestment.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.PauseScreen;
import stancempire.enquestment.network.util.ModScreen;
/**
 * <p>CLIENT CODE</p>
 * Handles all client-bound packages.
*/
public class ClientPacketHandler
{

    /**
     * <p>Displays the specified ModScreen to the client.</p>
     *
     * @param screen The ModScreen to be displayed
     *
    */
    public static void openGui(ModScreen screen)
    {

        if(screen == ModScreen.TEST)
        {

            Minecraft.getInstance().setScreen(new PauseScreen(true));

        }

    }

}
