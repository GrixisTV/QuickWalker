# RuneLite Integration Guide

Since we're having some Java/Gradle compatibility issues, here's how to manually integrate your plugin with RuneLite:

## Option 1: Direct Integration with RuneLite Source

1. **Clone RuneLite Repository**
   ```
   git clone https://github.com/runelite/runelite.git
   cd runelite
   ```

2. **Create Plugin Directory**
   Create a new directory for your plugin in the RuneLite source:
   ```
   mkdir -p runelite-client/src/main/java/net/runelite/client/plugins/rightclickwalker
   ```

3. **Copy Plugin Files**
   Copy your plugin files to the RuneLite project, updating the package declarations:

   **RightClickWalkerPlugin.java**
   ```java
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
   ```

   **RightClickWalkerConfig.java**
   ```java
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
   ```

   **RightClickWalkerInputListener.java**
   ```java
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
   ```

4. **Build and Run RuneLite**
   Use the RuneLite build system to compile and run the client:
   ```
   mvn clean install -DskipTests
   java -jar runelite-client/target/client-1.10.14-SNAPSHOT-shaded.jar
   ```

## Option 2: Use RuneLite Plugin Hub Development

1. **Install Git**
   Make sure Git is installed on your system.

2. **Clone the Plugin Hub Template**
   ```
   git clone https://github.com/runelite/plugin-hub.git
   cd plugin-hub
   ```

3. **Create Your Plugin Directory**
   ```
   mkdir -p plugins/right-click-walker
   ```

4. **Copy Your Plugin Files**
   Copy all your plugin files to this directory, maintaining the same package structure.

5. **Create Plugin Descriptor**
   Create a file `plugins/right-click-walker/right-click-walker.gradle.kts` with:
   ```kotlin
   version = "1.0.0"
   
   project.extra["PluginName"] = "Right Click Walker"
   project.extra["PluginDescription"] = "Allows you to walk by right-clicking instead of selecting the Walk Here option"
   
   tasks {
       jar {
           manifest {
               attributes(mapOf(
                   "Plugin-Version" to project.version,
                   "Plugin-Id" to nameToId(project.extra["PluginName"] as String),
                   "Plugin-Provider" to "YourName",
                   "Plugin-Description" to project.extra["PluginDescription"],
                   "Plugin-License" to "2-Clause BSD License"
               ))
           }
       }
   }
   ```

6. **Test Your Plugin**
   Follow the Plugin Hub documentation to test your plugin locally.

## Option 3: Use RuneLite Plugin Hub Directly

1. **Create a GitHub Repository**
   Create a new GitHub repository for your plugin.

2. **Push Your Code**
   Push your plugin code to the repository.

3. **Submit to Plugin Hub**
   Submit your plugin to the RuneLite Plugin Hub following their submission guidelines.

4. **Install from Plugin Hub**
   Once approved, users can install your plugin directly from the RuneLite Plugin Hub.
