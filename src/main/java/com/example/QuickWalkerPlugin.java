package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
    name = "ZZZ Quick Walker Test",
    description = "Enhances movement by allowing quick right-click walking for tiles, NPCs, players, and objects",
    tags = {"walking", "movement", "qol", "mouse", "navigation", "npc", "player"}
)
public class QuickWalkerPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private QuickWalkerConfig config;

    @Inject
    private MouseManager mouseManager;

    @Inject
    private QuickWalkerInputListener inputListener;

    @Override
    protected void startUp() throws Exception
    {
        log.info("Quick Walker plugin started!");
        mouseManager.registerMouseListener(inputListener);
        if (client.getGameState() == GameState.LOGGED_IN)
        {
            sendLoginMessage();
        }
    }

    @Override
    protected void shutDown() throws Exception
    {
        log.info("Quick Walker plugin stopped!");
        mouseManager.unregisterMouseListener(inputListener);
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged)
    {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
        {
            sendLoginMessage();
        }
    }

    private void sendLoginMessage()
    {
        if (config.enabled())
        {
            String message = "Quick Walker plugin active. ";
            if (config.shiftRightClick())
            {
                message += "Hold Shift + Right-Click to walk.";
            }
            else
            {
                message += "Right-Click to walk.";
            }
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", message, null);
        }
    }

    @Provides
    QuickWalkerConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(QuickWalkerConfig.class);
    }
}