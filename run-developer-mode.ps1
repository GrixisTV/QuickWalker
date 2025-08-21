# PowerShell script to run RuneLite in developer mode
# Author: GrixisTV
# Usage: .\run-developer-mode.ps1

# Check if RuneLite is installed in the expected location
$runeLitePath = "$env:LOCALAPPDATA\RuneLite\RuneLite.exe"

if (-not (Test-Path $runeLitePath)) {
    Write-Host "RuneLite executable not found at $runeLitePath" -ForegroundColor Red
    Write-Host "Please make sure RuneLite is installed correctly." -ForegroundColor Red
    exit 1
}

# Check if RuneLite is already running
$runeliteProcess = Get-Process -Name "RuneLite" -ErrorAction SilentlyContinue
if ($runeliteProcess) {
    Write-Host "RuneLite is currently running." -ForegroundColor Yellow
    Write-Host "It's recommended to close RuneLite before starting developer mode." -ForegroundColor Yellow
    $confirmation = Read-Host "Do you want to close RuneLite and continue? (y/n)"
    if ($confirmation -eq 'y') {
        Write-Host "Closing RuneLite..." -ForegroundColor Cyan
        $runeliteProcess | Stop-Process -Force
        Start-Sleep -Seconds 2
    } else {
        Write-Host "Operation cancelled. Please close RuneLite manually and try again." -ForegroundColor Red
        exit
    }
}

# Run RuneLite in developer mode
Write-Host "Starting RuneLite in developer mode..." -ForegroundColor Cyan
try {
    Start-Process -FilePath $runeLitePath -ArgumentList "--developer-mode", "--debug" -NoNewWindow
    Write-Host "RuneLite started in developer mode successfully!" -ForegroundColor Green
    Write-Host ""
    Write-Host "Developer tools are now available in the sidebar." -ForegroundColor Green
    Write-Host "Check the logs at $env:USERPROFILE\.runelite\logs\ for detailed information." -ForegroundColor Green
} catch {
    Write-Host "Failed to start RuneLite in developer mode:" -ForegroundColor Red
    Write-Host $_.Exception.Message -ForegroundColor Red
    exit 1
}
