# Quick Walker Plugin for RuneLite

A RuneLite plugin that enhances your Old School RuneScape experience by allowing you to walk to a location with just a right-click, eliminating the need to select the "Walk here" option from the context menu.

## Features

- Walk to a location by simply right-clicking (no need to select "Walk here" from the menu)
- Option to require Shift + Right-click for walking (configurable)
- Seamlessly integrates with the RuneLite client
- Improves navigation efficiency and reduces click fatigue

## How It Works

When you right-click somewhere in the game world, the Quick Walker plugin automatically selects the "Walk here" option for you, saving you time and reducing the number of clicks needed to navigate around the game world.

## Installation

### From Plugin Hub (Recommended)
1. Open RuneLite
2. Click on the Configuration icon (wrench)
3. Click on "Plugin Hub" at the bottom
4. Search for "Quick Walker"
5. Click "Install"

### Manual Installation
1. Download the latest release JAR file
2. Place it in your RuneLite plugins directory
3. Restart RuneLite

## Configuration Options

The plugin can be configured through the RuneLite settings panel:

1. **Enable/Disable**: Toggle the plugin functionality on or off
2. **Shift + Right-Click**: Optionally require holding the Shift key while right-clicking to activate the walking feature

## Development

### Prerequisites
- Java Development Kit (JDK) 11
- Git
- IntelliJ IDEA (recommended)

### Building from Source
1. Clone the repository:
   ```
   git clone https://github.com/GrixisTV/QuickWalker.git
   cd QuickWalker
   ```

2. Build the plugin:
   ```
   ./gradlew build
   ```

3. Run the plugin in development mode:
   ```
   ./gradlew runelitePluginDev
   ```

## License

This project is licensed under the BSD 2-Clause License - see the LICENSE file for details.

## Support

If you encounter any issues or have suggestions, please [open an issue](https://github.com/GrixisTV/QuickWalker/issues) on GitHub.