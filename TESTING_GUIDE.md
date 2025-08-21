# Testing Guide for Right Click Walker Plugin

## Prerequisites

1. **Install JDK 11 or newer**
   - Download from [AdoptOpenJDK](https://adoptopenjdk.net/) or [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
   - Make sure JAVA_HOME environment variable is set correctly

2. **Install Gradle**
   - Download from [gradle.org](https://gradle.org/install/)
   - Add Gradle to your PATH environment variable

3. **Clone RuneLite Repository**
   ```
   git clone https://github.com/runelite/runelite.git
   cd runelite
   ```

## Setting Up Your Plugin in RuneLite

### Option 1: Using IntelliJ IDEA (Recommended)

1. **Install IntelliJ IDEA**
   - Download from [jetbrains.com](https://www.jetbrains.com/idea/download/)
   - Community Edition is free and sufficient

2. **Import RuneLite Project**
   - Open IntelliJ IDEA
   - Select "Open" and navigate to the RuneLite repository you cloned
   - Wait for the project to import and index

3. **Copy Your Plugin Files**
   - Copy your plugin files to the RuneLite project:
     - Copy `src/main/java/com/example/RightClickWalkerPlugin.java` to `runelite/runelite-client/src/main/java/net/runelite/client/plugins/rightclickwalker/RightClickWalkerPlugin.java`
     - Copy `src/main/java/com/example/RightClickWalkerConfig.java` to `runelite/runelite-client/src/main/java/net/runelite/client/plugins/rightclickwalker/RightClickWalkerConfig.java`
     - Copy `src/main/java/com/example/RightClickWalkerInputListener.java` to `runelite/runelite-client/src/main/java/net/runelite/client/plugins/rightclickwalker/RightClickWalkerInputListener.java`

4. **Update Package Names**
   - Change the package declaration in each file from `package com.example;` to `package net.runelite.client.plugins.rightclickwalker;`
   - Update any import statements referring to the old package

5. **Run RuneLite**
   - Find the `RuneLite` class in the project explorer
   - Right-click and select "Run RuneLite.main()"

### Option 2: Using External Plugin System

1. **Set up the RuneLite external plugin repository**
   - Follow the guide at [Example External Plugin](https://github.com/runelite/example-plugin)

2. **Build the plugin**
   ```
   cd right-click-walker
   gradlew build
   ```

3. **Install the plugin in RuneLite**
   - Start RuneLite
   - Go to "Plugin Hub" in the configuration panel
   - Search for your plugin (if published) or use the "Install from file" option

## Testing the Plugin

1. **Start RuneLite** with your plugin installed

2. **Log into Old School RuneScape**

3. **Enable the Plugin**
   - Click the configuration icon (wrench)
   - Find "Right Click Walker" in the plugin list
   - Make sure it's enabled

4. **Test the Functionality**
   - Right-click somewhere in the game world
   - Your character should automatically walk there without showing the context menu
   - If you enabled the "Require Shift + Right-Click" option, hold Shift while right-clicking

5. **Verify Different Scenarios**
   - Test in different areas of the game
   - Test with different game objects and NPCs nearby
   - Test with the configuration options toggled on and off

## Troubleshooting

- **Plugin not appearing in the list**: Make sure the plugin is properly registered in the RuneLite plugin system
- **Right-click not working**: Check the RuneLite developer console for any error messages
- **Context menu still showing**: Verify that the plugin is enabled and the event is being properly consumed

## Publishing Your Plugin

Once tested, you can submit your plugin to the RuneLite Plugin Hub:
1. Create a GitHub repository for your plugin
2. Follow the submission guidelines at [Plugin Hub](https://github.com/runelite/plugin-hub)
