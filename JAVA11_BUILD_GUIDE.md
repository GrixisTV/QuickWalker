# Building Quick Walker with Java 11

This guide provides instructions for setting up and building the Quick Walker plugin using Java 11, which is the recommended version for RuneLite plugin development.

## Why Java 11?

RuneLite is built with Java 11 compatibility in mind, and using the same Java version for plugin development ensures maximum compatibility. While the plugin can be built with newer Java versions (like Java 17 or 23), using Java 11 avoids potential compatibility issues.

## Setting Up Java 11

### Windows

1. Download Java 11 JDK from [AdoptOpenJDK](https://adoptium.net/temurin/releases/?version=11) or [Oracle](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
2. Run the installer and follow the instructions
3. Set up JAVA_HOME environment variable:
   - Right-click on "This PC" or "My Computer" and select "Properties"
   - Click on "Advanced system settings"
   - Click on "Environment Variables"
   - Under "System variables", click "New"
   - Variable name: `JAVA_HOME`
   - Variable value: Path to your JDK 11 installation (e.g., `C:\Program Files\Java\jdk-11.0.12`)
   - Click "OK"
4. Add Java to PATH:
   - In the same "Environment Variables" dialog, find the "Path" variable under "System variables"
   - Click "Edit"
   - Click "New"
   - Add `%JAVA_HOME%\bin`
   - Click "OK" on all dialogs

### macOS

1. Install Java 11 using Homebrew:
   ```
   brew tap adoptopenjdk/openjdk
   brew install --cask adoptopenjdk11
   ```
2. Set JAVA_HOME in your shell profile:
   ```
   echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 11)' >> ~/.zshrc
   # Or for bash:
   # echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 11)' >> ~/.bash_profile
   ```
3. Reload your shell profile:
   ```
   source ~/.zshrc
   # Or for bash:
   # source ~/.bash_profile
   ```

### Linux

1. Install OpenJDK 11:
   ```
   # Ubuntu/Debian
   sudo apt update
   sudo apt install openjdk-11-jdk
   
   # Fedora/CentOS/RHEL
   sudo dnf install java-11-openjdk-devel
   ```
2. Set JAVA_HOME in your shell profile:
   ```
   echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> ~/.bashrc
   source ~/.bashrc
   ```

## Verifying Java Installation

To verify that Java 11 is correctly installed and set as the default:

```
java -version
```

You should see output indicating Java 11, for example:
```
openjdk version "11.0.12" 2021-07-20
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.12+7)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.12+7, mixed mode)
```

## Building the Plugin with Java 11

Once Java 11 is set up, you can build the plugin:

```
# Windows
cd C:\path\to\QuickWalker
.\gradlew clean build

# macOS/Linux
cd /path/to/QuickWalker
./gradlew clean build
```

The Gradle wrapper in the repository is configured to use Java 11 compatibility settings, so the build should succeed without any Java version issues.

## Switching Between Java Versions

If you have multiple Java versions installed and need to switch between them:

### Windows

Use the JAVA_HOME environment variable as described above.

### macOS

Use the `jenv` tool:
```
brew install jenv
jenv add $(/usr/libexec/java_home -v 11)
jenv global 11
```

### Linux

Use alternatives system:
```
sudo update-alternatives --config java
```

## Troubleshooting

### Build Fails with "Unsupported class file major version"

This error occurs when trying to build with a newer Java version than what Gradle is configured for. Solutions:

1. Switch to Java 11 as described above
2. Or update the Gradle wrapper to support your Java version:
   ```
   # For Java 17
   ./gradlew wrapper --gradle-version 7.3
   
   # For Java 21/23
   ./gradlew wrapper --gradle-version 8.5
   ```

### Cannot Find Tools.jar

If you encounter an error about missing `tools.jar`:

1. Make sure you're using a JDK, not a JRE
2. Verify that JAVA_HOME points to the JDK directory

### Other Issues

If you encounter other issues, please:
1. Check that your Java version is correct
2. Ensure Gradle is using the correct Java version
3. Try running with the `--info` flag for more details:
   ```
   ./gradlew build --info
   ```

