# run.ps1
# Script to compile, run, and clean up the Bridge Design Pattern project.

$buildDir = "bin"

try {
    # 1. Create build directory if it doesn't exist
    if (!(Test-Path -Path $buildDir)) {
        New-Item -ItemType Directory -Path $buildDir | Out-Null
    }

    # 2. Find all Java files
    Write-Host "========================================" -ForegroundColor Cyan
    Write-Host "Locating Java source files..." -ForegroundColor Cyan
    $javaFiles = Get-ChildItem -Path "src\main\java" -Filter "*.java" -Recurse | ForEach-Object { $_.FullName }

    if ($javaFiles.Count -eq 0) {
        throw "No Java source files found in src\main\java!"
    }

    Write-Host "Found $($javaFiles.Count) Java file(s)." -ForegroundColor Gray

    # 3. Compile everything
    Write-Host "Compiling Java files..." -ForegroundColor Cyan
    javac -d $buildDir $javaFiles
    if ($LASTEXITCODE -ne 0) {
        throw "Compilation failed with exit code $LASTEXITCODE"
    }
    Write-Host "Compilation successful!" -ForegroundColor Green
    Write-Host "========================================" -ForegroundColor Cyan

    # 4. Run the main class
    Write-Host "Running Main..." -ForegroundColor Cyan
    java -cp $buildDir Main
    Write-Host "========================================" -ForegroundColor Cyan

} catch {
    Write-Error $_
} finally {
    # 5. Delete artifacts
    if (Test-Path -Path $buildDir) {
        Write-Host "Cleaning up build artifacts..." -ForegroundColor Yellow
        Remove-Item -Path $buildDir -Recurse -Force | Out-Null
        Write-Host "Cleanup completed." -ForegroundColor Green
    }
}
