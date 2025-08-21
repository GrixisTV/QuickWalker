package net.runelite.client.plugins.rightclickwalker;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.MenuOpened;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import java.awt.event.MouseEvent;

@Slf4j
@PluginDescriptor(
    name = "Right Click Walker",
    description = "Allows you to walk by right-clicking instead of selecting the Walk Here option",
    tags = {"walking", "movement", "qol"}
)
public class RightClickWalkerPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private RightClickWalkerConfig config;

    @Inject
    private MouseManager mouseManager;

    @Inject
    private RightClickWalkerInputListener inputListener;

    @Override
    protected void startUp() throws Exception
    {
        log.info("Right Click Walker plugin started!");
        mouseManager.registerMouseListener(inputListener);
    }

    @Override
    protected void shutDown() throws Exception
    {
        log.info("Right Click Walker plugin stopped!");
        mouseManager.unregisterMouseListener(inputListener);
    }

    @Subscribe
    public void onMenuOpened(MenuOpened event)
    {
        if (!config.enabled())
        {
            return;
        }

        // This is where we can modify the menu if needed
    }

    @Subscribe
    public void onClientTick(ClientTick event)
    {
        if (!config.enabled() || client.isMenuOpen())
        {
            return;
        }

        // Additional logic can be added here if needed
    }

    @Provides
    RightClickWalkerConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(RightClickWalkerConfig.class);
    }
}
