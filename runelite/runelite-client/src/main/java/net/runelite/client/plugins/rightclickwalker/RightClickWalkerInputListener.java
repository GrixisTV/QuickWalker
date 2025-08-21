package net.runelite.client.plugins.rightclickwalker;

import java.awt.event.MouseEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.client.input.MouseListener;

public class RightClickWalkerInputListener implements MouseListener
{
    @Inject
    private Client client;

    @Inject
    private RightClickWalkerConfig config;

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
                    return e;
                }

                // Find the "Walk here" option in the menu
                MenuEntry[] menuEntries = client.getMenuEntries();
                for (int i = menuEntries.length - 1; i >= 0; i--)
                {
                    MenuEntry entry = menuEntries[i];
                    if (entry.getOption().equals("Walk here"))
                    {
                        // Select the "Walk here" option
                        client.setSelectedItemIndex(i);
                        client.invokeMenuAction(
                            entry.getOption(),
                            entry.getTarget(),
                            entry.getIdentifier(),
                            entry.getOpcode(),
                            entry.getParam0(),
                            entry.getParam1()
                        );
                        
                        // Consume the event to prevent the context menu from showing
                        e.consume();
                        break;
                    }
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
