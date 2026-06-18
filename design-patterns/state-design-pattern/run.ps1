# Powershell script to compile, run, and clean up build artifacts

$ErrorActionPreference = "Stop"

Write-Host "==============================================" -ForegroundColor Yellow
Write-Host "      Vending Machine State Design Pattern    " -ForegroundColor Yellow
Write-Host "==============================================" -ForegroundColor Yellow

# 1. Compilation
Write-Host "Compiling Java source files..." -ForegroundColor Cyan
if (!(Test-Path "bin")) {
    New-Item -ItemType Directory -Force -Path "bin" | Out-Null
}

try {
    javac -d bin src/main/java/Main.java src/main/java/context/VendingMachine.java src/main/java/states/*.java
    Write-Host "Compilation successful!" -ForegroundColor Green
} catch {
    Write-Host "Error during compilation." -ForegroundColor Red
    Exit 1
}

# 2. Execution
Write-Host "Running program..." -ForegroundColor Cyan
Write-Host "-------------------- OUTPUT --------------------" -ForegroundColor Gray
try {
    java -cp bin states.Main
} catch {
    Write-Host "Error during execution." -ForegroundColor Red
}
Write-Host "------------------------------------------------" -ForegroundColor Gray

# 3. Cleanup
Write-Host "Cleaning up build artifacts (deleting 'bin/' directory)..." -ForegroundColor Magenta
if (Test-Path "bin") {
    Remove-Item -Recurse -Force bin
}
Write-Host "Cleanup completed successfully!" -ForegroundColor Green
Write-Host "==============================================" -ForegroundColor Yellow
