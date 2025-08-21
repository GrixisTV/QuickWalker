package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("quickwalker")
public interface QuickWalkerConfig extends Config
{
    @ConfigItem(
        keyName = "enabled",
        name = "Enable Quick Walking",
        description = "Enable to walk by right-clicking without selecting the Walk Here option"
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
