# Ensure we exit on error
$ErrorActionPreference = "Stop"

# Define directories
$BinDir = "bin"
$SourceFiles = "src/main/java/*.java"

# Step 1: Compile
Write-Host "=== Compiling Java Files ===" -ForegroundColor Cyan
if (!(Test-Path $BinDir)) {
    New-Item -ItemType Directory -Path $BinDir | Out-Null
}
javac -d $BinDir src/main/java/*.java

# Step 2: Run
Write-Host "`n=== Running Application ===" -ForegroundColor Green
java -cp $BinDir Main

# Step 3: Cleanup
Write-Host "`n=== Cleaning Up Compilation Artifacts ===" -ForegroundColor Yellow
if (Test-Path $BinDir) {
    Remove-Item -Recurse -Force $BinDir
}
# Clean up any class files that might have been generated in the source folders
Get-ChildItem -Path "src" -Filter "*.class" -Recurse | Remove-Item -Force
Write-Host "Done!" -ForegroundColor Green

