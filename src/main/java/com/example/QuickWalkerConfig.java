package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("quickwalker")
public interface QuickWalkerConfig extends Config
{
    @ConfigItem(
        keyName = "enabled",
        name = "Enable Quick Walking",
        description = "Enable to walk by right-clicking without selecting the Walk Here option",
        position = 0
    )
    default boolean enabled()
    {
        return true;
    }

    @ConfigItem(
        keyName = "shiftRightClick",
        name = "Shift + Right-Click Only",
        description = "When enabled, quick walking only activates when holding Shift. This preserves normal right-click menus for other actions.",
        position = 1
    )
    default boolean shiftRightClick()
    {
        return true; // Changed default to true
    }

    @ConfigSection(
        name = "Entity Types",
        description = "Configure which entities can be right-clicked to walk to",
        position = 2
    )
    String entityTypesSection = "entityTypesSection";

    @ConfigItem(
        keyName = "enableTiles",
        name = "Enable for Ground Tiles",
        description = "Enable right-click walking for ground tiles",
        section = "entityTypesSection",
        position = 0
    )
    default boolean enableTiles()
    {
        return true;
    }

    @ConfigItem(
        keyName = "enableNpcs",
        name = "Enable for NPCs",
        description = "Enable right-click walking to walk to an NPC's location",
        section = "entityTypesSection",
        position = 1
    )
    default boolean enableNpcs()
    {
        return true;
    }

    @ConfigItem(
        keyName = "enablePlayers",
        name = "Enable for Players",
        description = "Enable right-click walking to walk to another player's location",
        section = "entityTypesSection",
        position = 2
    )
    default boolean enablePlayers()
    {
        return true;
    }

    @ConfigItem(
        keyName = "enableObjects",
        name = "Enable for Game Objects",
        description = "Enable right-click walking to walk to game objects (trees, rocks, etc.)",
        section = "entityTypesSection",
        position = 3
    )
    default boolean enableObjects()
    {
        return true;
    }
}