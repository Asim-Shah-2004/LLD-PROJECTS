# Compile and run the template design pattern implementation

# Ensure the build directory exists
if (-not (Test-Path -Path "bin")) {
    New-Item -ItemType Directory -Path "bin" | Out-Null
}

Write-Host "Compiling Java sources..."
javac -d bin -sourcepath src/main/java src/main/java/Main.java

if ($LASTEXITCODE -eq 0) {
    Write-Host "Execution output:"
    Write-Host "-----------------"
    java -cp bin Main
    Write-Host "-----------------"
} else {
    Write-Error "Compilation failed."
}

Write-Host "Cleaning up build artifacts..."
if (Test-Path -Path "bin") {
    Remove-Item -Recurse -Force "bin"
}
