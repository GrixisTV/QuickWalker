# Quick Walker Plugin for RuneLite

A RuneLite plugin that enhances your Old School RuneScape experience by allowing you to walk to a location with just a right-click, eliminating the need to select the "Walk here" option from the context menu.

## Features

- Walk to a location by simply right-clicking (no need to select "Walk here" from the menu)
- Option to require Shift + Right-click for walking (configurable)
- Configurable to enable/disable quick walking for:
  - Ground Tiles
  - NPCs
  - Players
  - Game Objects
- Seamlessly integrates with the RuneLite client
- Improves navigation efficiency and reduces click fatigue

## How It Works

When you right-click somewhere in the game world, the Quick Walker plugin automatically selects the "Walk here" option for you, saving you time and reducing the number of clicks needed to navigate around the game world.

## Installation

### From Plugin Hub (Coming Soon)
1. Open RuneLite
2. Click on the Configuration icon (wrench)
3. Click on "Plugin Hub" at the bottom
4. Search for "Quick Walker"
5. Click "Install"

### Manual Installation
1. Download the latest release JAR file from the [Releases page](https://github.com/GrixisTV/QuickWalker/releases)
2. Place it in your RuneLite plugins directory:
   - Windows: `%USERPROFILE%\.runelite\plugins`
   - macOS/Linux: `~/.runelite/plugins`
3. Restart RuneLite

## Configuration Options

The plugin can be configured through the RuneLite settings panel:

1. **Enable Quick Walking**: Toggle the plugin functionality on or off.
2. **Require Shift + Right-Click**: When enabled, quick walking only activates when holding the Shift key while right-clicking. This preserves normal right-click menus for other actions.

### Entity Types
Control which types of entities can be right-clicked to walk to:
- **Enable for Ground Tiles**: Enable right-click walking for ground tiles.
- **Enable for NPCs**: Enable right-click walking to walk to an NPC's location.
- **Enable for Players**: Enable right-click walking to walk to another player's location.
- **Enable for Game Objects**: Enable right-click walking to walk to game objects (trees, rocks, etc.).

## Development

### Prerequisites
- Java Development Kit (JDK) 11 or higher
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
   # Windows
   .\gradlew clean build -x checkstyleMain -x checkstyleTest
   
   # macOS/Linux
   ./gradlew clean build -x checkstyleMain -x checkstyleTest
   ```

3. The built JAR file will be in the `build/libs` directory.

4. Install the plugin:
   ```
   # Windows
   Copy-Item "build\libs\quick-walker-1.0-SNAPSHOT.jar" -Destination "$env:USERPROFILE\.runelite\plugins\quick-walker-1.0-SNAPSHOT.jar" -Force
   
   # macOS/Linux
   cp build/libs/quick-walker-1.0-SNAPSHOT.jar ~/.runelite/plugins/
   ```

## Troubleshooting

- **Plugin not appearing in configuration**: Make sure the JAR file is correctly placed in the RuneLite plugins directory and that RuneLite is completely restarted.
- **Java version issues**: The plugin is built for Java 11 compatibility (required by RuneLite), but can be built with newer Java versions using the Gradle wrapper included in the repository.
- **Build errors**: If you encounter checkstyle errors, use the `-x checkstyleMain -x checkstyleTest` flags as shown in the build commands above.

## License

This project is licensed under the BSD 2-Clause License - see the LICENSE file for details.

## Support

If you encounter any issues or have suggestions, please [open an issue](https://github.com/GrixisTV/QuickWalker/issues) on GitHub.