# PowerShell script to commit and push changes to GitHub
# Usage: .\update-github.ps1 "Your commit message here"

param(
    [Parameter(Mandatory=$true)]
    [string]$CommitMessage
)

# Check if git is installed
if (!(Get-Command git -ErrorAction SilentlyContinue)) {
    Write-Error "Git is not installed or not in PATH. Please install Git and try again."
    exit 1
}

# Check if we're in a git repository
if (!(Test-Path .git)) {
    Write-Error "This doesn't appear to be a Git repository. Please run this script from the root of your QuickWalker repository."
    exit 1
}

# Stage all changes
Write-Host "Staging all changes..." -ForegroundColor Cyan
git add .

# Commit changes
Write-Host "Committing changes with message: $CommitMessage" -ForegroundColor Cyan
git commit -m "$CommitMessage"

# Push to origin
Write-Host "Pushing changes to GitHub..." -ForegroundColor Cyan
git push origin main

# Check if push was successful
if ($LASTEXITCODE -eq 0) {
    Write-Host "Changes successfully pushed to GitHub!" -ForegroundColor Green
} else {
    Write-Host "Failed to push changes to GitHub. Please check the error message above." -ForegroundColor Red
}
