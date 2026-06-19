# run.ps1
# Script to compile, run, and clean up the Visitor Design Pattern project

$ErrorActionPreference = "Stop"

Write-Host "==========================================================" -ForegroundColor Cyan
Write-Host "       VISITOR DESIGN PATTERN RUNNER (POWERSHELL)        " -ForegroundColor Cyan
Write-Host "==========================================================" -ForegroundColor Cyan

# 1. Prepare bin directory
$BinDir = Join-Path $PSScriptRoot "bin"
if (Test-Path $BinDir) {
    Write-Host "[*] Cleaning existing bin directory..." -ForegroundColor Yellow
    Remove-Item -Recurse -Force $BinDir
}
New-Item -ItemType Directory -Path $BinDir | Out-Null

# 2. Find and compile all Java files
Write-Host "[*] Finding Java source files..." -ForegroundColor Yellow
$JavaFiles = Get-ChildItem -Path (Join-Path $PSScriptRoot "src") -Filter "*.java" -Recurse | ForEach-Object { $_.FullName }

if ($JavaFiles.Count -eq 0) {
    Write-Host "[!] No Java files found in src/ directory!" -ForegroundColor Red
    exit 1
}

Write-Host "[*] Compiling $($JavaFiles.Count) Java files to bin/..." -ForegroundColor Yellow
try {
    javac -d $BinDir $JavaFiles
    Write-Host "[+] Compilation successful!" -ForegroundColor Green
} catch {
    Write-Host "[!] Compilation failed. Please check errors above." -ForegroundColor Red
    if (Test-Path $BinDir) { Remove-Item -Recurse -Force $BinDir }
    exit 1
}

# 3. Run the application
Write-Host "==========================================================" -ForegroundColor Gray
Write-Host "                   RUNNING APPLICATION                    " -ForegroundColor Gray
Write-Host "==========================================================" -ForegroundColor Gray

try {
    java -cp $BinDir Main
} catch {
    Write-Host "[!] Execution failed." -ForegroundColor Red
}

Write-Host "==========================================================" -ForegroundColor Gray

# 4. Cleanup
Write-Host "[*] Cleaning up build artifacts..." -ForegroundColor Yellow
if (Test-Path $BinDir) {
    Remove-Item -Recurse -Force $BinDir
}
Write-Host "[+] Cleanup complete. Done!" -ForegroundColor Green
