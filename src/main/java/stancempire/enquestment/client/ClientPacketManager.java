package stancempire.enquestment.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.PauseScreen;
import stancempire.enquestment.network.util.ModScreen;

public class ClientPacketManager
{

    public static void openGui(ModScreen screen)
    {

        if(screen == ModScreen.TEST)
        {

            Minecraft.getInstance().setScreen(new PauseScreen(true));

        }

    }

}
