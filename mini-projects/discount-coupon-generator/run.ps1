# Compile the Java project
Write-Host "Compiling the project..."
if (-not (Test-Path -Path "bin")) {
    New-Item -ItemType Directory -Path "bin" | Out-Null
}
javac -d bin src/main/java/Main.java src/main/java/coupons/*.java src/main/java/enums/*.java src/main/java/external/*.java src/main/java/strategies/*.java

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation succeeded. Running Main..."
    # Run the application
    java -cp bin Main
    
    # Delete the compile artifacts
    Write-Host "Cleaning up compile artifacts..."
    Remove-Item -Recurse -Force bin
    Write-Host "Cleanup complete."
} else {
    Write-Host "Compilation failed."
    exit $LASTEXITCODE
}
