# Quick Walker Plugin for RuneLite

This plugin enhances your Old School RuneScape experience by allowing you to walk to a location with just a right-click, eliminating the need to select the "Walk here" option from the context menu.

## Features

- Walk to a location by simply right-clicking (no need to select "Walk here" from the menu)
- Option to require Shift + Right-click for walking (configurable)
- Seamlessly integrates with the RuneLite client
- Improves navigation efficiency and reduces click fatigue

## How It Works

When you right-click somewhere in the game world, the Quick Walker plugin automatically selects the "Walk here" option for you, saving you time and reducing the number of clicks needed to navigate around the game world.

## Configuration Options

The plugin can be configured through the RuneLite settings panel:

1. **Enable/Disable**: Toggle the plugin functionality on or off
2. **Shift + Right-Click**: Optionally require holding the Shift key while right-clicking to activate the walking feature

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK) 11 or newer
- Git
- IntelliJ IDEA (recommended)

### Building and Running

1. Clone the RuneLite repository:
   ```
   git clone https://github.com/runelite/runelite.git
   cd runelite
   ```

2. Build RuneLite:
   ```
   mvn clean install -DskipTests
   ```

3. Clone this plugin repository:
   ```
   cd ..
   git clone [your-plugin-repo-url]
   cd quick-walker
   ```

4. Build the plugin:
   ```
   ./gradlew build
   ```

5. Run the plugin:
   ```
   ./gradlew runelitePluginDev
   ```

## License

This project is licensed under the BSD 2-Clause License - see the LICENSE file for details.