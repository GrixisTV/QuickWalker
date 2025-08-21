# Setting Up RuneLite Developer Mode

This guide will help you run RuneLite in developer mode, which provides additional debugging information and tools to help with plugin development.

## Method 1: Using Command Line Arguments

1. Close RuneLite completely if it's currently running

2. Open a Command Prompt or PowerShell window

3. Navigate to your RuneLite installation directory:
   ```
   cd C:\Users\Legion\AppData\Local\RuneLite
   ```

4. Run RuneLite with the developer mode flag:
   ```
   RuneLite.exe --developer-mode --debug
   ```

## Method 2: Creating a Shortcut with Developer Mode

1. Right-click on your desktop or in a folder and select **New > Shortcut**

2. In the location field, enter:
   ```
   "C:\Users\Legion\AppData\Local\RuneLite\RuneLite.exe" --developer-mode --debug
   ```

3. Click **Next** and give your shortcut a name like "RuneLite Developer Mode"

4. Click **Finish**

5. Use this shortcut whenever you want to run RuneLite in developer mode

## What Developer Mode Provides

When running in developer mode, you'll have access to:

1. **Developer Tools**: Access to additional developer tools and debugging features

2. **Detailed Logging**: More verbose logging to help identify issues

3. **Plugin Inspection**: Better visibility into plugin loading and behavior

4. **Widget Inspector**: Tools to inspect and interact with game UI elements

## Using Developer Tools

Once RuneLite is running in developer mode, you can access the developer tools:

1. Click on the **Developer Tools** icon in the sidebar (it looks like a wrench)

2. This will open a panel with various development tools:
   - Widget Inspector
   - Plugin List
   - Plugin Hub
   - Event Logger
   - And more

## Troubleshooting Plugin Loading

With developer mode enabled, you can:

1. Check the console output for detailed information about plugin loading

2. Look for any errors or warnings related to your plugin

3. Use the Plugin List in developer tools to see which plugins are loaded

4. Check if your plugin appears in the list (even if it doesn't show in the configuration panel)

## Next Steps

After running RuneLite in developer mode, check the logs for any information about your Quick Walker plugin. This should help identify why it's not appearing in the configuration panel.

If you need to view the logs, they are located at:
```
%USERPROFILE%\.runelite\logs\
```

Look for any messages related to plugin loading, particularly for your plugin.
