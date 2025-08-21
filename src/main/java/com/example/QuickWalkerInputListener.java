package com.example;

import java.awt.event.MouseEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.client.input.MouseListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuickWalkerInputListener implements MouseListener
{
    @Inject
    private Client client;

    @Inject
    private QuickWalkerConfig config;

    @Override
    public MouseEvent mouseClicked(MouseEvent e)
    {
        return e;
    }

    @Override
    public MouseEvent mousePressed(MouseEvent e)
    {
        return e;
    }

    @Override
    public MouseEvent mouseReleased(MouseEvent e)
    {
        // Check if right mouse button was clicked
        if (e.getButton() == MouseEvent.BUTTON3)
        {
            // Check if the plugin is enabled
            if (config.enabled())
            {
                // Check if shift is required and if it's being held
                if (config.shiftRightClick() && !e.isShiftDown())
                {
                    return e; // Do not consume if shift is required but not held
                }

                MenuEntry[] menuEntries = client.getMenuEntries();
                MenuEntry walkHereEntry = null;

                // Iterate through menu entries to find "Walk here"
                for (int i = menuEntries.length - 1; i >= 0; i--)
                {
                    MenuEntry entry = menuEntries[i];
                    if (entry.getOption().equals("Walk here"))
                    {
                        walkHereEntry = entry;
                        break;
                    }
                }

                if (walkHereEntry != null)
                {
                    // Select the "Walk here" option by setting it as the only menu entry
                    client.setMenuEntries(new MenuEntry[]{walkHereEntry});
                    
                    // Consume the event to prevent the context menu from showing
                    e.consume();
                }
            }
        }
        return e;
    }

    @Override
    public MouseEvent mouseEntered(MouseEvent e)
    {
        return e;
    }

    @Override
    public MouseEvent mouseExited(MouseEvent e)
    {
        return e;
    }

    @Override
    public MouseEvent mouseDragged(MouseEvent e)
    {
        return e;
    }

    @Override
    public MouseEvent mouseMoved(MouseEvent e)
    {
        return e;
    }
}