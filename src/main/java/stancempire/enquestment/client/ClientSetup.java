package stancempire.enquestment.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyModifier;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;
import stancempire.enquestment.Enquestment;

public class ClientSetup
{

    @SubscribeEvent
    public void onClientSetup(final FMLClientSetupEvent event)
    {

        event.enqueueWork(() ->
        {

            Enquestment.LOGGER.info("Client Setup");
            //CLIENT SETUPM

        });

    }

    public static final Lazy<KeyMapping> EMENU_KEY = Lazy.of(() -> new KeyMapping("key.enquestment.emenu", KeyConflictContext.IN_GAME, KeyModifier.ALT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_E, "key.categories.misc"));

    @SubscribeEvent
    public void registerKeybinds(RegisterKeyMappingsEvent event)
    {

        event.register(EMENU_KEY.get());

    }

}
