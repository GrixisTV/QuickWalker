# Troubleshooting Guide for Quick Walker Plugin

If you're having issues with the Quick Walker plugin not appearing in RuneLite's configuration panel, here are some troubleshooting steps to try:

## 1. Verify Plugin Installation

First, make sure the plugin JAR file is correctly installed in the RuneLite plugins directory:

```
%USERPROFILE%\.runelite\plugins\zzz-quick-walker-test-1.0-SNAPSHOT.jar
```

## 2. Check RuneLite Version

Make sure you're using a recent version of RuneLite. The plugin is developed for the latest stable release.

## 3. Try Developer Mode

RuneLite has a developer mode that can provide more information about plugin loading:

1. Close RuneLite completely
2. Open a command prompt
3. Navigate to your RuneLite installation directory
4. Run RuneLite with the developer flag:
   ```
   RuneLite.exe --developer-mode
   ```
5. Check the logs for any errors related to plugin loading

## 4. Check Java Version Compatibility

The plugin is built for Java 11 compatibility, which is what RuneLite uses. If you're building with a newer Java version, make sure to set the compatibility level correctly in `build.gradle`:

```gradle
tasks.withType(JavaCompile).configureEach {
    options.encoding = 'UTF-8'
    options.release.set(11) // Set to Java 11 for RuneLite compatibility
}
```

## 5. Verify Plugin Manifest

The plugin JAR file must contain specific manifest attributes for RuneLite to recognize it. The key attributes are:

- `Plugin-Id`: Must be unique
- `Plugin-Class`: Must point to the main plugin class (e.g., `com.example.QuickWalkerPlugin`)
- `Plugin-Version`: Version number
- `Plugin-Provider`: Author name
- `Plugin-Description`: Short description

## 6. Check Package Structure

Make sure the package structure in your code matches the one specified in the manifest. For example, if your `Plugin-Class` is `com.example.QuickWalkerPlugin`, then your class should be in the `com.example` package.

## 7. Restart RuneLite Completely

Sometimes RuneLite doesn't fully reload plugins on restart. Try:
1. Close RuneLite
2. End any RuneLite processes in Task Manager
3. Delete the `.runelite\cache` directory
4. Restart RuneLite

## 8. Alternative Installation Method

If the plugin still doesn't appear, try this alternative installation method:

1. Close RuneLite
2. Create a new directory in your RuneLite installation folder called `plugins`
3. Copy your plugin JAR file to this new directory
4. Start RuneLite

## 9. Check RuneLite Logs

Examine the RuneLite logs for any errors:

```
%USERPROFILE%\.runelite\logs\
```

Look for any messages related to your plugin or errors during plugin loading.

## 10. Try a Clean RuneLite Installation

As a last resort, you can try with a clean RuneLite installation:

1. Uninstall RuneLite
2. Delete the `.runelite` directory in your user profile
3. Reinstall RuneLite
4. Install your plugin

## Contact for Support

If you've tried all these steps and still have issues, please open an issue on the GitHub repository with details about your environment and the steps you've taken.
