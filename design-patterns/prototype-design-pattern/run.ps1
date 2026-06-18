# Get the script directory
$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
if ([string]::IsNullOrEmpty($scriptDir)) {
    $scriptDir = Get-Location
}

# Define paths
$sourceDir = Join-Path $scriptDir "src/main/java"
$binDir = Join-Path $scriptDir "bin"

Write-Host "==========================================" -ForegroundColor Cyan
Write-Host "  Prototype Design Pattern Runner (Java)  " -ForegroundColor Cyan
Write-Host "==========================================" -ForegroundColor Cyan

# Step 1: Compilation
Write-Host "`n[1/3] Compiling Java source files..." -ForegroundColor Yellow
if (!(Test-Path $binDir)) {
    New-Item -ItemType Directory -Path $binDir -Force | Out-Null
}

$sources = Get-ChildItem -Path $sourceDir -Filter "*.java" | ForEach-Object { $_.FullName }

if ($sources.Count -eq 0) {
    Write-Error "No Java source files found in $sourceDir"
    exit 1
}

# Run javac
javac -d $binDir $sources
if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed!"
    exit $LASTEXITCODE
}
Write-Host "Compilation successful. Class files placed in '$binDir'." -ForegroundColor Green

# Step 2: Running the code
Write-Host "`n[2/3] Executing Main class..." -ForegroundColor Yellow
Write-Host "----------------- OUTPUT -----------------" -ForegroundColor Gray
java -cp $binDir Main
$runExitCode = $LASTEXITCODE
Write-Host "------------------------------------------" -ForegroundColor Gray

if ($runExitCode -ne 0) {
    Write-Warning "Application exited with code $runExitCode."
} else {
    Write-Host "Application ran successfully." -ForegroundColor Green
}

# Step 3: Cleanup
Write-Host "`n[3/3] Cleaning up artifacts..." -ForegroundColor Yellow
if (Test-Path $binDir) {
    Remove-Item -Recurse -Force $binDir
    Write-Host "Deleted temporary compilation folder '$binDir'." -ForegroundColor Green
}

Write-Host "`nDone!" -ForegroundColor Cyan
