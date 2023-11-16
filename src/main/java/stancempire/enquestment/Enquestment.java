package stancempire.enquestment;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stancempire.enquestment.client.ClientSetup;
import stancempire.enquestment.events.UserEvents;
import stancempire.enquestment.network.NetworkManager;

@Mod(Enquestment.MOD_ID)
public class Enquestment
{


    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "enquestment";

    public Enquestment()
    {

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus eventBus = NeoForge.EVENT_BUS;

        modBus.addListener(this::onCommonSetup);
        if(FMLEnvironment.dist.isClient())
        {

            modBus.register(new ClientSetup());

        }

        eventBus.register(new UserEvents());

    }

    private void onCommonSetup(final FMLCommonSetupEvent event)
    {

        event.enqueueWork(() ->
        {

            LOGGER.info("Common Setup");
            NetworkManager.registerMessages();

        });

    }

}
