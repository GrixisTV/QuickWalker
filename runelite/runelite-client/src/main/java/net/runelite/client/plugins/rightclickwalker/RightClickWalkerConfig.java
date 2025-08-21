package net.runelite.client.plugins.rightclickwalker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("rightclickwalker")
public interface RightClickWalkerConfig extends Config
{
    @ConfigItem(
        keyName = "enabled",
        name = "Enable Right-Click Walking",
        description = "Enable to walk by right-clicking instead of selecting Walk Here option"
    )
    default boolean enabled()
    {
        return true;
    }
    
    @ConfigItem(
        keyName = "shiftRightClick",
        name = "Require Shift + Right-Click",
        description = "Require holding shift while right-clicking to walk"
    )
    default boolean shiftRightClick()
    {
        return false;
    }
}
