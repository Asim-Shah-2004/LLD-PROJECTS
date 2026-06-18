# Get the directory of this script
$ScriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path

# Define the build output directory
$BinDir = Join-Path $ScriptDir "bin"

# Create the bin directory if it doesn't exist
if (!(Test-Path $BinDir)) {
    New-Item -ItemType Directory -Path $BinDir -Force | Out-Null
}

# Find all Java source files under the src directory
$SrcDir = Join-Path $ScriptDir "src"
Write-Host "Locating Java source files in $SrcDir..." -ForegroundColor Cyan
$JavaFiles = Get-ChildItem -Path $SrcDir -Filter *.java -Recurse | Select-Object -ExpandProperty FullName

if ($null -eq $JavaFiles -or $JavaFiles.Count -eq 0) {
    Write-Host "Error: No Java files found to compile!" -ForegroundColor Red
    exit 1
}

Write-Host "Compiling $($JavaFiles.Count) Java file(s) into '$BinDir'..." -ForegroundColor Cyan

# Compile all files using javac
javac -d $BinDir -sourcepath "$SrcDir/main/java" $JavaFiles

if ($LastExitCode -ne 0) {
    Write-Host "Compilation failed with exit code $LastExitCode" -ForegroundColor Red
    # Clean up anyway even if compilation failed, to leave a clean state
    if (Test-Path $BinDir) {
        Remove-Item -Recurse -Force $BinDir | Out-Null
    }
    exit $LastExitCode
}

Write-Host "Compilation successful!" -ForegroundColor Green
Write-Host "Running Main class..." -ForegroundColor Green
Write-Host "================== OUTPUT ==================" -ForegroundColor Magenta

# Run the compiled program
java -cp $BinDir Main
$RunExitCode = $LastExitCode

Write-Host "============================================" -ForegroundColor Magenta
Write-Host "Cleaning up compilation artifacts..." -ForegroundColor Yellow

# Clean up compilation artifacts
if (Test-Path $BinDir) {
    Remove-Item -Recurse -Force $BinDir | Out-Null
    Write-Host "Removed temporary compilation directory '$BinDir'." -ForegroundColor Green
}

exit $RunExitCode
