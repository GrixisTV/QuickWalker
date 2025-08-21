# PowerShell script to build and install the Quick Walker plugin
# Author: GrixisTV
# Usage: .\build-and-install.ps1

# Check if RuneLite is running
$runeliteProcess = Get-Process -Name "RuneLite" -ErrorAction SilentlyContinue
if ($runeliteProcess) {
    Write-Host "WARNING: RuneLite is currently running." -ForegroundColor Yellow
    Write-Host "It's recommended to close RuneLite before updating the plugin." -ForegroundColor Yellow
    $confirmation = Read-Host "Do you want to continue anyway? (y/n)"
    if ($confirmation -ne 'y') {
        Write-Host "Operation cancelled. Please close RuneLite and try again." -ForegroundColor Red
        exit
    }
}

# Define paths
$pluginJar = "quick-walker-1.0-SNAPSHOT.jar"
$buildPath = "build\libs\$pluginJar"
$pluginsDir = "$env:USERPROFILE\.runelite\plugins"
$targetPath = "$pluginsDir\$pluginJar"

# Create plugins directory if it doesn't exist
if (-not (Test-Path $pluginsDir)) {
    Write-Host "Creating RuneLite plugins directory..." -ForegroundColor Cyan
    New-Item -Path $pluginsDir -ItemType Directory -Force | Out-Null
}

# Clean and build the plugin
Write-Host "Building Quick Walker plugin..." -ForegroundColor Cyan
try {
    # Run Gradle build command
    & .\gradlew clean build -x checkstyleMain -x checkstyleTest
    
    if ($LASTEXITCODE -ne 0) {
        Write-Host "Build failed with exit code $LASTEXITCODE" -ForegroundColor Red
        exit $LASTEXITCODE
    }
} catch {
    Write-Host "An error occurred during the build process:" -ForegroundColor Red
    Write-Host $_.Exception.Message -ForegroundColor Red
    exit 1
}

# Check if build was successful
if (-not (Test-Path $buildPath)) {
    Write-Host "Build failed: JAR file not found at $buildPath" -ForegroundColor Red
    exit 1
}

# Install the plugin
Write-Host "Installing plugin to RuneLite..." -ForegroundColor Cyan
try {
    # Remove old JAR if it exists
    if (Test-Path $targetPath) {
        Remove-Item $targetPath -Force -ErrorAction Stop
    }
    
    # Copy new JAR
    Copy-Item $buildPath -Destination $targetPath -Force -ErrorAction Stop
    
    Write-Host "Plugin successfully installed to $targetPath" -ForegroundColor Green
} catch {
    Write-Host "Failed to install plugin:" -ForegroundColor Red
    Write-Host $_.Exception.Message -ForegroundColor Red
    exit 1
}

# Final instructions
Write-Host ""
Write-Host "Installation complete!" -ForegroundColor Green
Write-Host "To use the plugin:"
Write-Host "1. Start RuneLite (or restart if it's already running)"
Write-Host "2. Enable the 'ZZZ Quick Walker Test' plugin in the configuration panel"
Write-Host "3. Configure the plugin options as desired"
Write-Host ""
Write-Host "Happy gaming!" -ForegroundColor Cyan
