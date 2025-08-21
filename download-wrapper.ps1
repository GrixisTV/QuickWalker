$wrapperJar = "gradle/wrapper/gradle-wrapper.jar"
$wrapperUrl = "https://github.com/gradle/gradle/raw/master/gradle/wrapper/gradle-wrapper.jar"

if (-Not (Test-Path $wrapperJar)) {
    Write-Host "Downloading Gradle wrapper JAR..."
    Invoke-WebRequest -Uri $wrapperUrl -OutFile $wrapperJar
    Write-Host "Downloaded Gradle wrapper JAR"
} else {
    Write-Host "Gradle wrapper JAR already exists"
}
