# Compile and run client.Client
# Usage: ./run-client.ps1

if (-not (Get-Command javac -ErrorAction SilentlyContinue)) {
    Write-Error "javac not found. Install JDK and add to PATH."
    exit 1
}
if (-not (Get-Command java -ErrorAction SilentlyContinue)) {
    Write-Error "java not found. Install JDK and add to PATH."
    exit 1
}

$root = $PSScriptRoot
$src = Join-Path $root "src\main\java"
$bin = Join-Path $root "bin"

if (-not (Test-Path $src)) {
    Write-Error "Source folder not found: $src"
    exit 1
}

if (-not (Test-Path $bin)) {
    New-Item -ItemType Directory -Path $bin | Out-Null
}

Write-Host "Finding Java source files..." -ForegroundColor Cyan
$javaFiles = Get-ChildItem -Path $src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
if ($javaFiles.Count -eq 0) {
    Write-Error "No Java sources found in $src"
    exit 1
}

Write-Host "Compiling Java sources to $bin..." -ForegroundColor Cyan
& javac -d $bin -sourcepath $src $javaFiles
if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed (javac exit code $LASTEXITCODE)"
    exit $LASTEXITCODE
}

Write-Host "Running client.Client..." -ForegroundColor Cyan
& java -cp $bin client.Client

if ($LASTEXITCODE -ne 0) {
    Write-Error "Program exited with code $LASTEXITCODE"
} else {
    Write-Host "Program finished with exit code $LASTEXITCODE" -ForegroundColor Green
}

# Remove bin directory after run
if (Test-Path $bin) {
    Write-Host "Removing build output folder: $bin" -ForegroundColor Cyan
    try {
        Remove-Item -Recurse -Force $bin -ErrorAction Stop
        Write-Host "Removed $bin" -ForegroundColor Green
    } catch {
        Write-Warning "Failed to remove ${bin}: $($_)"
    }
}

exit $LASTEXITCODE
