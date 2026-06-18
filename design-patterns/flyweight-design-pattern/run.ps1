# run.ps1 - Compiles, runs, and cleans up Java artifacts

$binDir = "bin"

try {
    Write-Host "Compiling Java source files..." -ForegroundColor Cyan
    # Ensure compile directory exists
    if (-not (Test-Path $binDir)) {
        New-Item -ItemType Directory -Path $binDir | Out-Null
    }

    # Compile the Java project
    javac -d $binDir -sourcepath src/main/java src/main/java/Main.java
    if ($LASTEXITCODE -ne 0) {
        Write-Error "Compilation failed!"
        exit $LASTEXITCODE
    }

    Write-Host "Running Main program..." -ForegroundColor Green
    # Execute the program
    java -cp $binDir Main

} finally {
    # Delete the compiled artifacts
    if (Test-Path $binDir) {
        Write-Host "Cleaning up compiled artifacts..." -ForegroundColor Yellow
        Remove-Item -Recurse -Force $binDir
    }
}
